const bikerTable ="http://localhost:8080/bikers/all"

async function fetchAllBikerS(){
  return fetch(bikerTable).then(response => response.json())
}

console.log(fetchAllBikerS())
