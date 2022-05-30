const teams = "http://localhost:8080/team/all"
document.addEventListener('DOMContentLoaded', createFormEventListener);

let bikerForm

function createFormEventListener() {
  bikerForm = document.getElementById('newBiker');
  bikerForm.addEventListener('submit', handleFormSubmit);
}


async function handleFormSubmit(event) {
  event.preventDefault();
  const url = event.currentTarget;
  const form = form.action;
  console.log(form)
  try {
    const formData = new FormData(form);
    await postFormDataAsJson(url, formData);

  } catch (err) {
    console.log(err.message);
  }
}

async function postFormDataAsJson(url, formData) {
  console.log(formData)
  const plainFormData = Object.fromEntries(formData.entries());

  const formDataJsonString = JSON.stringify(plainFormData);

  const fetchOptions = {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(formDataJsonString)
  };

  const response = await fetch(url, fetchOptions);
  if (!response) {
    const errorMessage = await response.text();
    throw new Error(errorMessage);
  }

  return response.json();
}
