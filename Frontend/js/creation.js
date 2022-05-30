const teams = "http://localhost:8080/team/all"
document.addEventListener('DOMContentLoaded', creatFormEventListener);

function fetchTeams() {
  return fetch(teams).then(response => response.json());
}

async function createTeamOptions(){
  const teamList = await fetchTeams();

  for (let team of teamList){

    let parent = document.getElementById("parent")
    let option = document.createElement("option")
    option.textContent = team.teamName;
    parent.appendChild(option);
  }
}

createTeamOptions()

function creatFormEventListener(){
  let bikerForm = document.getElementById("newBiker")
  bikerForm.addEventListener('submit', handleFormSubmit)
}

async function handleFormSubmit(event) {
  //preventDefault forhindrer form i at udføre default submit. altås sende sig selv til backend.
  event.preventDefault();
  const form = event.currentTarget;
  const url = form.action;

  try {
    const formData = new FormData(form);
    await postFormDataAsJson(url, formData);
  } catch (err) {
    alert(err.message);
    console.log(err);
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
