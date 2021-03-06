const allBikers = "http://localhost:8081/biker/all"


async function fetchBikers() {
  return fetch(allBikers).then(response => response.json())
}

async function printBikerTable() {

  const bikerList = await fetchBikers();
  console.log(bikerList)
  for (let biker of bikerList) {
    let parent = document.getElementById("parent")
    let tableRow = document.createElement("tr")
    let td1 = document.createElement("td")
    td1.textContent = biker.bikerId;
    let td2 = document.createElement("td")
    td2.textContent = biker.bikerName;
    let td3 = document.createElement("td")
    td3.textContent = biker.bikerTime;


    parent.appendChild(tableRow)
    tableRow.appendChild(td1);
    tableRow.appendChild(td2)
    tableRow.appendChild(td3)
  }
}

printBikerTable()
