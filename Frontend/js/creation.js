const teams = "http://localhost:8080/team/all"

function fetchTeams() {
  return fetch(teams).then(response => response.json());
}
document.addEventListener('DOMContentLoaded', creatFormEventListener);
let bikerForm

function creatFormEventListener(){
  bikerForm = document.getElementById("newBiker")
  bikerForm.addEventListener('submit', handleFormSubmit)
}
/*
async function createTeamOptions(){
  const teamList = await fetchTeams();

  for (let team of teamList){

    let parent = document.getElementById("parent")
    let option = document.createElement("option")
    option.id = "bikerTeam"
    option.textContent = team.teamName;
    parent.appendChild(option);
  }
}

createTeamOptions()

 */


async function handleFormSubmit(event) {
  event.preventDefault();
  const form = event.currentTarget;
  const url = form.action;
console.log(form)
  try {
    const formData = new FormData(form);
    await postFormDataAsJson(url, formData);

  } catch (err) {
    alert(err.message);
  }
}

async function postFormDataAsJson(url, formData) {

  const plainFormData = Object.fromEntries(formData.entries());
  const formDataJsonString = JSON.stringify(plainFormData);

  const fetchOptions = {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: formDataJsonString
  };

  const response = await fetch(url, fetchOptions);
  if (!response) {
    const errorMessage = await response.text();
    throw new Error(errorMessage);
  }
  return response;
}
