const postBiker = "http://localhost:8081/biker/new"

document.addEventListener('DOMContentLoaded', createFormEventListener);

function createFormEventListener() {
  const bikerForm = document.getElementById('newBiker');
  bikerForm.addEventListener('submit', handleFormSubmit);
}

async function handleFormSubmit(event) {
  event.preventDefault();
  const form = event.currentTarget;
  try {
    const formData = new FormData(form);
    await postFormDataAsJson(postBiker, formData).then(response => response.json());
  } catch (err) {
    console.log(err)
  }
}


async function postFormDataAsJson(url, formData) {

  const plainFormData = Object.fromEntries(formData.entries());
  const formDataJsonString = JSON.stringify(plainFormData);
  console.log(plainFormData)
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


/*

async function handleFormSubmit(event) {
  event.preventDefault();
  const form = event.currentTarget;
  const url = postCustomerUrl.form;

  try {
    const formData = new FormData(form);
    await postFormDataAsJson(url, formData).then(response => response.json());
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
 */

