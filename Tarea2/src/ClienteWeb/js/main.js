console.log(sessionStorage);

if (sessionStorage.imageURL != null){
    if (sessionStorage.imageURL){
        let avatarName = document.getElementById("user-name");
        let allAvatarIconElements = document.getElementsByClassName("avatar icon");
        let avatarImgArray = Array.from(allAvatarIconElements);
        let avatarImg = avatarImgArray[0];

        avatarImg.src = sessionStorage.imageURL;
        avatarName.textContent = sessionStorage.nombre;

        let firstDropdown = document.getElementById("dropdown-1");
        let secondDropdown = document.getElementById("dropdown-2");

        firstDropdown.href = "./consultaDeUsuario.html";
        firstDropdown.textContent = "Ver Perfil";

        secondDropdown.href = "./cerrarSesion.html";
        secondDropdown.textContent = "Cerrar Sesion";
    }
}