const bikerTable = "http://localhost:8080/biker/all"

async function fetchAllBikerS() {
  return fetch(bikerTable).then(response => response.json())
}

async function printBikerTable() {
  const bikerList = await fetchAllBikerS();

  for (let biker of bikerList) {
    let parent = document.getElementById("parent")


    console.log(biker)
    const tableRow = document.createElement("tr")

    let td1 = document.createElement("td")
    td1.textContent = biker.bikerId;
    let td2 = document.createElement("td")
    td2.textContent = biker.name;
    let td3 = document.createElement("td")
    td3.textContent = biker.teamName;
    let td4 = document.createElement("td")
    td4.textContent = biker.mountainPoints

      parent.appendChild(tableRow)
    tableRow.appendChild(td1);
    tableRow.appendChild(td2)
    tableRow.appendChild(td3)
    tableRow.appendChild(td4)
  }
}


printBikerTable()


