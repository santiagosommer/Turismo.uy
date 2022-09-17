function GoToPreviousPage(){
    window.history.go(-1);
}

function GoToIndex(){
    window.location.href = "./../index.html";
}

let cancelButton = document.getElementById("cancelButton");

cancelButton.addEventListener("click", () => {
    if (window.history.length > 1) {
        GoToPreviousPage();
    }
    else {
        GoToIndex();
    }
})