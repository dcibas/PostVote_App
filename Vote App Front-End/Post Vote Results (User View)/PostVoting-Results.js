let myresultsId = localStorage.getItem("resultsid");

fetch(`http://localhost:8090/api/results/${myresultsId}`, {method: "GET",
  headers: {
    "Content-type": "application/json",
    "Authorization": `Bearer ` + localStorage.getItem("token")
  },})
    .then((res) => res.json())
    .then((data) => {
        document.getElementById(
          "votingchoicePoints"
        ).innerHTML += `<br> Completely Against:
      ${data.votingPoints1} <br><br> Partially Against: ${data.votingPoints2} 
      <br><br> Partially Agree: ${data.votingPoints3} 
      <br><br> Completely Agree: ${data.votingPoints4}
      <br><br><br>
      `;
      
    });

    let myvotepostId = localStorage.getItem("votepostid");

    fetch(`http://localhost:8090/api/votepost/${myvotepostId}`, {method: "GET",
      headers: {
        "Content-type": "application/json",
        "Authorization": `Bearer ` + localStorage.getItem("token")
      },})
        .then((res) => res.json())
        .then((data) => { 
            document.getElementById("resultsTitle").textContent +=
              " " + data.votingTitle;
            document.getElementById(
              "votingEndDate"
            ).textContent += " " +
          data.endDate;
      
        });

let backBtn = document.getElementById("back");
backBtn.addEventListener("click", back);

function back(e) {
e.preventDefault();
history.back();
}

let logoutBtn = document.getElementById("logout");
logoutBtn.addEventListener("click", logout);

function logout(e) {
  e.preventDefault();
  alert("You have successfully logged out!");
  window.location.href = "http://127.0.0.1:5500/Login%20Form/VoteApp-Login.html";
}