let baseDeProveedores = [
    {
        "nickname": "washington",
        "nombre": "Washington",
        "apellido": "Rocha",
        "email": "washington@turismorocha.gub.uy",
        "fechaNacimiento": "14/09/1970",
        "descripcion": "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay",
        "url": "http://turismorocha.gub.uy/",
        "imageURL": "https://c.wallhere.com/photos/55/39/safe_house_cia_agent_tobin_frost_denzel_washington-584127.jpg!d",
        "actividades": [
            {
                "nombre": "Degusta",
                "duracion": 3,
                "costo": 800,
                "ciudad": "Rocha",
                "departamento": "Rocha",
                "fechaAlta": "20/7/2022",
                "imageURL": "https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg",
                "confirmacion": "Confirmada"
            },
            {
                "nombre": "Teatro con Sabores",
                "duracion": 3,
                "costo": 500,
                "ciudad": "Rocha",
                "departamento": "Rocha",
                "fechaAlta": "21/7/2022",
                "imageURL": "https://s3.amazonaws.com/turismorocha/eventos/2579/cover/teatro-con-sabores-008950900-1659638152.jpg",
                "confirmacion": "Confirmada"
            }
        ]
    }
];

let baseDeTuristas = [
    {
        "nickname": "lachiqui",
        "nombre": "Rosa Maria",
        "apellido": "Martinez",
        "email": "mirtha.legrand.ok@hotmail.com.ar",
        "fechaNacimiento": "23/2/1927",
        "nacionalidad": "Argentina",
        "imageURL": "https://pbs.twimg.com/media/EOHAP9zWoAsnkiM?format=jpg&name=small",
        "inscripciones":[
            {
                "tipo": "General",
                "cantidadTuristas": 3,
                "costo": 2400,
                "salidaNombre": "Degusta Agosto",
                "fechaInscripcion": "15/8/2022",
                "imageURL": "https://city.woow.com.uy/media/catalog/product/cache/dcf64a24127a43d9ce9fe76e3e5f8061/n/u/nueva2_3_1.jpg"
            },
            {
                "tipo": "General",
                "cantidadTuristas": 3,
                "costo": 1200,
                "salidaNombre": "Degusta Setiembre",
                "fechaInscripcion": "18/8/2022",
                "imageURL": "https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG"
            }
        ],
        "paquetes":[
            {
                "nombre": "Disfrutar Rocha",
                "cantidadTuristas": 2,
                "fechaCompra": "15/8/2022",
                "imageURL": "https://sites.google.com/site/areasprotegidasenuruguay/_/rsrc/1411660757953/algunas-de-las-areas-ingresadas-por-el-snap/laguna-de-rocha/Mapa_Rocha_BLOG.jpg?height=280&width=400"
            },
            {
                "nombre": "Un dia en Colonia",
                "cantidadTuristas": 5,
                "fechaCompra": "20/8/2022",
                "imageURL": "https://www.lr21.com.uy/wp-content/uploads/2021/12/plaza-toros-colonia.jpg"
            }
        ]
    }
]

const divPerfil = document.getElementById("Perfil");
const titleNombre = document.getElementById("title-nombre");
const titleNicknameEmail = document.getElementById("title-nickname-email");
const imgPerfil = document.getElementById("img-perfil");

let nicknameLogged = sessionStorage.nickname;
if (nicknameLogged == null){
    alert("No hay usuario loggeado.");
}
let isProveedor = true;
let userFound = false;
let userData = {};

baseDeProveedores.every( proveedor =>
    {
        if(proveedor.nickname == nicknameLogged)
        {
            userFound = true;
            userData = proveedor;
            return false;
        }
        return true;
    }
);

if (userFound){
    console.log("Es proveedor, populando pagina...");
    populateWebProveedor();
}
else{
    isProveedor = false;
    baseDeTuristas.every( turista =>
        {
            if(turista.nickname == nicknameLogged)
            {
                userData = turista;
                userFound = true;
                return false;
            }
            return true;
        }
    );
    if (userFound){
        console.log("Es turista, populando pagina...");
        populateWebTurista();
    }
    else{
        alert("No se encontro usuario en BD");
    }
}

function populateWebTurista(){
    imgPerfil.src = userData.imageURL;
    titleNombre.textContent = userData.nombre + " " + userData.apellido;
    titleNicknameEmail.textContent = userData.nickname + " / " + userData.email;

    const nickname = document.createElement("p");
    const nombre = document.createElement("p");
    const apellido = document.createElement("p");
    const email = document.createElement("p");
    const fechaNacimiento = document.createElement("p");
    const nacionalidad = document.createElement("p");

    nickname.innerHTML = "<b>" + "Nickname: " + "</b> " + userData.nickname;
    nombre.innerHTML = "<b>" + "Nombre: " + "</b> " + userData.nombre;
    apellido.innerHTML = "<b>" + "Apellido: " + "</b> " + userData.apellido;
    email.innerHTML = "<b>" + "E-mail: " + "</b> " + userData.email;
    fechaNacimiento.innerHTML = "<b>" + "Fecha de Nacimiento: " + "</b> " + userData.fechaNacimiento;
    nacionalidad.innerHTML = "<b>" + "Descripcion: " + "</b> " + userData.nacionalidad;

    divPerfil.appendChild(nickname);
    divPerfil.appendChild(nombre);
    divPerfil.appendChild(apellido);
    divPerfil.appendChild(email);
    divPerfil.appendChild(fechaNacimiento);
    divPerfil.appendChild(nacionalidad);

    const tabActividades = document.getElementById("Actividades-tab-container");
    tabActividades.style.display = "none";

    const divInscripciones = document.getElementById("Salidas");

    userData.inscripciones.forEach(inscripcion => {
        let divInscripcion = document.createElement("div");
        divInscripcion.classList = "Salida";

        let divImagenInscripcion = document.createElement("div")
        divImagenInscripcion.classList = "imagenSalida";
        let img = document.createElement("img");
        img.src = inscripcion.imageURL;
        divImagenInscripcion.append(img);

        let divInscripcionText = document.createElement("div");
        divInscripcionText.classList = "Salida-text";
        let inscripcionTipo = document.createElement("h5");
        inscripcionTipo.textContent = inscripcion.tipo;
        let inscripcionCantTuristas = document.createElement("h6");
        inscripcionCantTuristas.textContent = "Cantidad Turistas: " + inscripcion.cantidadTuristas;
        let inscripcionFechaInscripcion = document.createElement("h5");
        inscripcionFechaInscripcion.textContent = "Fecha de Inscripcion: " + inscripcion.fechaInscripcion;
        let inscripcionSalidaNombre = document.createElement("h3");
        inscripcionSalidaNombre.textContent = inscripcion.salidaNombre;


        divInscripcionText.append(inscripcionSalidaNombre);
        divInscripcionText.append(inscripcionTipo);
        divInscripcionText.append(inscripcionCantTuristas);
        divInscripcionText.append(inscripcionFechaInscripcion);



        divInscripcion.append(divImagenInscripcion);
        divInscripcion.append(divInscripcionText);

        divInscripciones.append(divInscripcion);
    });

    const divPaquetes = document.getElementById("Paquetes");

    userData.paquetes.forEach(paquetes => {
        let divPaquete = document.createElement("div");
        divPaquete.classList = "Paquete";

        let divImagenPaquete = document.createElement("div")
        divImagenPaquete.classList = "imagenPaquete";
        let img = document.createElement("img");
        img.src = paquetes.imageURL;
        divImagenPaquete.append(img);

        let divPaqueteText = document.createElement("div");
        divPaqueteText.classList = "Paquete-text";
        let paqueteNombre = document.createElement("h3");
        paqueteNombre.textContent = paquetes.nombre;
        let inscripcionCantTuristas = document.createElement("h6");
        inscripcionCantTuristas.textContent = "Cantidad Turistas: " + paquetes.cantidadTuristas;
        let paqueteFechaCompra = document.createElement("h5");
        paqueteFechaCompra.textContent = "Fecha de Compra: " + paquetes.fechaCompra;



        divPaqueteText.append(paqueteNombre);
        divPaqueteText.append(inscripcionCantTuristas);
        divPaqueteText.append(paqueteFechaCompra);

        divPaquete.append(divImagenPaquete);
        divPaquete.append(divPaqueteText);

        divPaquetes.append(divPaquete);
    })
};

function populateWebProveedor(){
    //Popular top del recuadro y foto
    imgPerfil.src = userData.imageURL;
    titleNombre.textContent = userData.nombre + " " + userData.apellido;
    titleNicknameEmail.textContent = userData.nickname + " / " + userData.email;

    //Popular Perfil
    const nickname = document.createElement("p");
    const nombre = document.createElement("p");
    const apellido = document.createElement("p");
    const email = document.createElement("p");
    const fechaNacimiento = document.createElement("p");
    const descripcion = document.createElement("p");
    const url = document.createElement("p");

    nickname.innerHTML = "<b>" + "Nickname: " + "</b> " + userData.nickname;
    nombre.innerHTML = "<b>" + "Nombre: " + "</b> " + userData.nombre;
    apellido.innerHTML = "<b>" + "Apellido: " + "</b> " + userData.apellido;
    email.innerHTML = "<b>" + "E-mail: " + "</b> " + userData.email;
    fechaNacimiento.innerHTML = "<b>" + "Fecha de Nacimiento: " + "</b> " + userData.fechaNacimiento;
    descripcion.innerHTML = "<b>" + "Descripcion: " + "</b> " + userData.descripcion;
    url.innerHTML = "<b>" + "URL: " + "</b> " + userData.url;

    divPerfil.appendChild(nickname);
    divPerfil.appendChild(nombre);
    divPerfil.appendChild(apellido);
    divPerfil.appendChild(email);
    divPerfil.appendChild(fechaNacimiento);
    divPerfil.appendChild(descripcion);
    divPerfil.appendChild(url);

    //Esconder tabs de turista
    const tabSalidas = document.getElementById("Salidas-tab-container");
    const tabPaquetes = document.getElementById("Paquetes-tab-container");

    tabSalidas.style.display = "none";
    tabPaquetes.style.display = "none";

    const divActividades = document.getElementById("Actividades");

    //Popular Tab Actividades
    userData.actividades.forEach(actividad => {
        let divActividad = document.createElement("div");
        divActividad.classList = "Actividad";


        let divImagenActividad = document.createElement("div")
        divImagenActividad.classList = "imagenActividad";
        let img = document.createElement("img");
        img.src = actividad.imageURL;
        divImagenActividad.append(img);

        let divActividadText = document.createElement("div");
        divActividadText.classList = "Actividad-text";
        let actividadNombre = document.createElement("h3");
        actividadNombre.textContent = actividad.nombre;
        let actividadConfirmacion = document.createElement("h6");
        actividadConfirmacion.textContent = "Estado: " + actividad.confirmacion;
        let actividadCiudad = document.createElement("h5");
        actividadCiudad.textContent = "Ciudad: " + actividad.ciudad;
        let actividadDpto = document.createElement("h5");
        actividadDpto.textContent = "Departamento: " + actividad.departamento;
        let actividadDuracion = document.createElement("h5");
        actividadDuracion.textContent = "Duracion: " + actividad.duracion;
        let actividadFechaAlta = document.createElement("h5");
        actividadFechaAlta.textContent = "Fecha de Alta: " + actividad.fechaAlta;



        divActividadText.append(actividadNombre);
        divActividadText.append(actividadConfirmacion);
        divActividadText.append(actividadCiudad);
        divActividadText.append(actividadDpto);
        divActividadText.append(actividadDuracion);
        divActividadText.append(actividadFechaAlta);


        divActividad.append(divImagenActividad);
        divActividad.append(divActividadText);

        divActividades.append(divActividad);
    });
};
