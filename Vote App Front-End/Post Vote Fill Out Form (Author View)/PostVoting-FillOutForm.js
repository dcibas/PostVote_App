let logoutBtn = document.getElementById("logout");
logoutBtn.addEventListener("click", logout);

function logout(e) {
  e.preventDefault();
  alert("You have successfully logged out!");
  window.location.href = "http://127.0.0.1:5500/Login%20Form/VoteApp-Login.html";
}

let voteBtn = document.getElementById("vote");
voteBtn.addEventListener("click", vote);

function vote(e) {
e.preventDefault();

let myvotepostId = localStorage.getItem("votepostid");

fetch(`http://localhost:8090/api/votepost/${myvotepostId}`, {method: "GET",
  headers: {
    "Content-type": "application/json",
    "Authorization": `Bearer ` + localStorage.getItem("token")
  },})
    .then((res) => res.json())
    .then((data) => {
        if(localStorage.getItem("userid") == data.userId) {
         window.location.href = "http://127.0.0.1:5500/Post%20Vote%20Posted%20Form%20(Author%20View)/PostVoting-PostedVoteForm.html";
        }
        else {
         window.location.href = "http://127.0.0.1:5500/Post%20Vote%20Posted%20Form%20(Voter%20View)/PostVoting-PostedVoteForm.html";
        }
    });
}

let resultsBtn = document.getElementById("results");
resultsBtn.addEventListener("click", results);

function results(e) {
e.preventDefault();

let myuserId = localStorage.getItem("userid");

fetch(`http://localhost:8090/api/users/${myuserId}`, {method: "GET",
headers: {
  "Content-type": "application/json",
  "Authorization": `Bearer ` + localStorage.getItem("token")
},})
  .then((res) => res.json())
  .then((data) => {  
      if(data.roles[0].role == "ROLE_ADMIN") {
       window.location.href = "http://127.0.0.1:5500/Post%20Vote%20Results%20(Admin%20View)/PostVoting-Results.html";
      }
      else {
       window.location.href = "http://127.0.0.1:5500/Post%20Vote%20Results%20(User%20View)/PostVoting-Results.html";
      }
  });
}

let subBtn = document.getElementById("submit");
subBtn.addEventListener("click", submit);

function submit(e) {
  
  e.preventDefault();
  let myTitle = document.getElementById("votingtitle").value;
  let myDescription = document.getElementById("votingdescription").value;
  let myEnddate = document.getElementById("enddate").value;

  fetch(`http://localhost:8090/api/votepost`, {
    method: "POST",
    headers: {
      "Content-type": "application/json",
      "Authorization": `Bearer ` + localStorage.getItem("token")
    },
    body: JSON.stringify({
      votingTitle: myTitle,
      endDate: myEnddate,
      votingDescription: myDescription,
      userId: localStorage.getItem("userid"),
    }),
  })
  .then((res) => {
    if(res.ok) {
    alert("Congratulations! You have successfully submited a vote post!");
    window.location.href =
     "http://127.0.0.1:5500/Post%20Vote%20Posted%20Form%20(Author%20View)/PostVoting-PostedVoteForm.html";
    location.reload(); 
    } 
    else {
    alert("A vote post already exists or you need to fully complete the form!");
    }
    return res;
  })
  .then((res) => res.json())
  .then((data) => { if(data.id != undefined) {
    localStorage.setItem("votepostid", data.id);
  }})
  .catch((error) => alert(error));
}
