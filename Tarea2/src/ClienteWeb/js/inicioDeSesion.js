function GoToPreviousPage(){
    window.history.back();
}

function GoToIndex(){
    window.location.href = "./../index.html";
}

function setCookie(name,value,days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
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
        "imageURL": "./../icons/bus.svg"
    },
    {
        "nickname": "washington",
        "nombre": "Washington",
        "apellido": "Rocha",
        "email": "washington@turismorocha.gub.uy",
        "password": "washi123",
        "imageURL": "./../icons/bus.svg"
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
                setCookie("nickname",element.nickname,1);
                setCookie("nombre",element.nombre,1);
                setCookie("apellido",element.apellido,1);
                setCookie("imageURL",element.imageURL,1);
                console.log(getCookie());
                correctPassword = true;
                userLogged = element;
                return false;
            }
        }
        return true;
    });
    if (foundId){
        if (correctPassword){
            /*GoToIndex()*/;
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