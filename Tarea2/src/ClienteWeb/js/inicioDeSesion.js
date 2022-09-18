function GoToPreviousPage(){
    window.history.back();
}

function GoToIndex(){
    window.location.href = "./index.html";
}

let cancelButton = document.getElementById("cancelButton");
let iniciarButton = document.getElementById("iniciarButton");

let idIn = "";
let passwordIn = "";
let foundId = false;
let correctPassword = false;
let userLogged = {};
let baseDeUsuarios = [
    {
        "nickname": "lachiqui",
        "nombre": "Rosa Maria",
        "apellido": "Martınez",
        "email": "mirtha.legrand.ok@hotmail.com.ar",
        "password": "rosita",
        "imageURL": "./../photos/lachiqui.jpg"
    },
    {
        "nickname": "washington",
        "nombre": "Washington",
        "apellido": "Rocha",
        "email": "washington@turismorocha.gub.uy",
        "password": "washi123",
        "imageURL": "./../photos/washington.jpg"
    }
];


console.log(document.cookie);

iniciarButton.addEventListener("click", () => {
    let idContent = document.getElementById("id-input").value;
    let passwordContent = document.getElementById("password-input").value;
    baseDeUsuarios.every(element => {
        if (element.nickname == idContent || element.email == idContent){
            foundId = true;
            if (element.password == passwordContent){
                sessionStorage.nickname = element.nickname;
                sessionStorage.nombre = element.nombre;
                sessionStorage.apellido = element.apellido;
                sessionStorage.imageURL = element.imageURL;

                correctPassword = true;
                userLogged = element;
                return false;
            }
        }
        return true;
    });
    if (foundId){
        if (correctPassword){
            GoToIndex();
        }
        else{
            alert("Password incorrecto.")
        }
    }
    else{
        alert("No existe password.");
    }
})

cancelButton.addEventListener("click", () => {
    if (window.history.length > 1) {
        GoToPreviousPage();
    }
    else {
        GoToIndex();
    }
})