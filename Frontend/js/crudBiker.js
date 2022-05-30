


//Update
async function updateBiker(biker) {

  const fetchOptions = {
    method: "PUT",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(body)
  };
  const response = await fetch(url, fetchOptions);

  if (!response) {
    const errorMessage = await response.text();
    console.log(errorMessage)
    throw new Error(errorMessage);

  }
}
