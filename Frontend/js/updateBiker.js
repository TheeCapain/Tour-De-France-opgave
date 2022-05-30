

async function updateStatusPost(post) {

  console.log(body)
  const fetchOptions = {
    method: "PUT",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(body)
  };
  const response = await fetch(url + post.id, fetchOptions);

  if (!response) {
    const errorMessage = await response.text();
    console.log(errorMessage)
    throw new Error(errorMessage);

  }
}
