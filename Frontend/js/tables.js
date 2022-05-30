const bikerTable = "http://localhost:8081/team/all"


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
      let td2 = document.createElement("td")
      td2.textContent = team.teamMembers[i].bikerName;
      td2.id = team.teamMembers[i].bikerId
      let name = document.createElement("input")
      name.type = "text"
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
      update.onclick = function () {
        updateBiker(team.teamMembers[i].bikerId)
      }
      let td5 = document.createElement("td")
      let deletebtn = document.createElement("button")
      deletebtn.onclick = function () {
        deleteBiker(team.teamMembers[i].bikerId)
        alert(team.teamMembers[i].bikerName + " Vil blive fjernet ved at trykke på Load updates")
      }
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

//Update
async function updateBiker(biker) {
  console.log(biker)
  const url = "http://localhost:8081/biker/" + biker;

  const fetchOptions = {
    method: "PUT",
    headers: {
      "Content-type": "application/json"
    },
    body: ""
  }
  const jsonString = JSON.stringify(biker);
  fetchOptions.body = jsonString;

  //calls backend and wait for return
  const response = await fetch(url, fetchOptions);

  out(response);
  if (!response.ok) {
    out("Det gik ikke godt med update");
  };

  return response;
}


//Delete
  async function deleteBiker(id) {
    const url = "http://localhost:8081/biker/delete/" + id;

    const fetchOptions = {
      method: "DELETE",
      headers: {
        "Content-type": "application/json"
      },
      body: ""
    }
    const response = await fetch(url, fetchOptions);

    if (!response.ok) {
      console.log("fejl")
    }

    return response;
  }


