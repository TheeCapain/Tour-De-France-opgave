const sortedTable = "http://localhost:8081/biker/sortedBest"

async function fetchSorted() {
  return fetch(sortedTable).then(response => response.json())
}


async function printSortedTable() {

  const bikerList = await fetchSorted();
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

printSortedTable()
