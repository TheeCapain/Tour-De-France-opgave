const bikerTable = "http://localhost:8080/team/all"

async function fetchAllBikers() {
  return fetch(bikerTable).then(response => response.json())
}

async function printBikerTable() {
  const teamList = await fetchAllBikers();

  for (let team of teamList) {
    for (let i = 0; i < team.teamMembers.length; i++) {
      console.log(team.teamMembers[i].bikerName)

      let parent = document.getElementById("parent")
      let tableRow = document.createElement("tr")
      let td1 = document.createElement("td")
      td1.textContent = team.teamID;
      let name = document.createElement("input")
      let td2 = document.createElement("td")
      td2.textContent = team.teamMembers[i].bikerName;
      let td3 = document.createElement("td")
      let selector = document.createElement("select")

      for (let team of teamList) {
        let option = document.createElement("option")
        option.textContent = team.teamName
        console.log(option.textContent)
        selector.appendChild(option)
      }


      let td4 = document.createElement("td")
      let update = document.createElement("button")
      update.textContent = "Update rider"
      update.className = "btn btn-success"
      let td5 = document.createElement("td")
      let deletebtn = document.createElement("button")
      deletebtn.textContent = "Delete rider"
      deletebtn.className = "btn btn-danger"


      parent.appendChild(tableRow)
      tableRow.appendChild(td1);
      tableRow.appendChild(td2)
      tableRow.appendChild(td3)
      td3.appendChild(selector)
      tableRow.appendChild(td4)
      td4.appendChild(update)
      tableRow.appendChild(td5)
      td5.appendChild(deletebtn)

    }
  }
}


