//------------------------------GAILUAK--------------------------------
//---------------------------------------------------------------------
// Gailu elektronikoen taulan, egoera zutabean bereiztu aukera ezberdinak:
const gailuakTaulaTD = document.querySelectorAll(".tdEgoera");
gailuakTaulaTD.forEach(item => {
    switch (item.textContent) {
        case "erabilgarri":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "hartua":
            item.style.color = "#da070a";
            break;
        case "mantenuan":
            item.style.color = "#a27014";
            break;
        case "bajan":
            item.style.color = "#1e3a8a";
    }
});

// Gailu elektronikoen selecta egitean (egoerarekiko) option bakoitzari bere kolorea eman
const gailuakEgoera = document.querySelectorAll("#selektEgoera option");
gailuakEgoera.forEach(item => {
    switch (item.textContent) {
        case "erabilgarri":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "hartua":
            item.style.color = "#da070a";
            break;
        case "mantenuan":
            item.style.color = "#a27014";
            break;
        case "bajan":
            item.style.color = "#1e3a8a";
    }
});

// Gailu elektronikoen selecta egitean (egoerarekiko) valueri bere kolorea eman
const gailuakEgoeraAukeratua = document.querySelector("#selektEgoera");
gailuakEgoeraAukeratua.addEventListener("change", gailuEgoeraKoloreaJarri);

function gailuEgoeraKoloreaJarri(){
switch (gailuakEgoeraAukeratua.value) {
    case "Guztiak":
        gailuakEgoeraAukeratua.style.color = "black";
        break;
    case "erabilgarri":
        gailuakEgoeraAukeratua.style.color = "rgb(1, 149, 151)";
        break;
    case "hartua":
        gailuakEgoeraAukeratua.style.color = "#da070a";
        break;
    case "mantenuan":
        gailuakEgoeraAukeratua.style.color = "#a27014";
        break;
    case "bajan":
        gailuakEgoeraAukeratua.style.color = "#1e3a8a";
}
};

//---------------------------------------------------------------------------
//----------------------GAILUAK BILAKETAK------------------------------------
//---------------------------------------------------------------------------
const gailuakMota = document.querySelector("#selektMota");
gailuakMota.addEventListener("change", bilatuGailua);
gailuakEgoeraAukeratua.addEventListener("change", bilatuGailua);
const gailuakGela = document.querySelector("#selektGela");
gailuakGela.addEventListener("change", bilatuGailua);
const gailuakBilatu = document.querySelector("#bilatuGailua");
gailuakBilatu.addEventListener("input", bilatuGailua);

function bilatuGailua(){
    const mota=gailuakMota.value;
    const egoera=gailuakEgoeraAukeratua.value;
    const gela=gailuakGela.value;
    const gakoa=gailuakBilatu.value.toLowerCase();
   
    const errenkadakGailuak=document.querySelectorAll("#gailuakTaula tbody tr");
    const errenkadakEgon=document.querySelectorAll("#egonTaula tbody tr");


    //Gailuak taulako errenkada bakoitza aztertu
    errenkadakGailuak.forEach(errenkada =>{
        let motaIkusgai=false;
        let egoeraIkusgai=false;
        let gakoaIkusgai=false;
        let gelaIkusgai=false;
        

        const errenkadakoMota=errenkada.querySelector(".tdMota");
        //Gailu mota
        if (mota==="Guztiak" || mota===errenkadakoMota.textContent){
            motaIkusgai=true;
        }
        //Gailu egoera
        const errenkadakoEgoera=errenkada.querySelector(".tdEgoera");
        if (egoera==="Guztiak" || egoera===errenkadakoEgoera.textContent){
            egoeraIkusgai=true;
        }
        //Gailua gakoa
        const errenkadaTextua=errenkada.innerText.toLowerCase();
        if (gakoa===null || errenkadaTextua.includes(gakoa)){
            gakoaIkusgai=true;
        }
        //Gela
        const errenkadakoGela=errenkada.querySelector(".tdIdGela");
        //Gailu mota
        if (gela==="Guztiak" || gela===errenkadakoGela.textContent){
            gelaIkusgai=true;
        }

        if (motaIkusgai && gakoaIkusgai && egoeraIkusgai && gelaIkusgai){
            errenkada.style.display="";
        }else{
            errenkada.style.display="none";
        }
    });
}


//------------------------------HISTORIKOAK----------------------------
//---------------------------------------------------------------------
// Kudeaketen taulan, Mota zutabean bereiztu aukera ezberdinak:
const KudeatuTaulaTD = document.querySelectorAll(".tdMota");
KudeatuTaulaTD.forEach(item => {
    switch (item.textContent) {
        case "gehitu":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "editatu":
            item.style.color = "#a27014";
            break;
        case "ezabatu":
            item.style.color = "#1e3a8a";
    }
});

// Kudeaketen selecta egitean (motarekiko) option bakoitzari bere kolorea eman
const kudeaketaMota = document.querySelectorAll("#selektKudeaketaMota option");
kudeaketaMota.forEach(item => {
    switch (item.textContent) {
        case "gehitu":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "editatu":
            item.style.color = "#a27014";
            break;
        case "ezabatu":
            item.style.color = "#1e3a8a";
    }
});

// Kudeaketen selecta egitean (motarekiko) valueri bere kolorea eman
const kudeaketaMotaAukeratua = document.querySelector("#selektKudeaketaMota");
kudeaketaMotaAukeratua.addEventListener("change", kudeaketaMotaKoloreaJarri);

function kudeaketaMotaKoloreaJarri(){
    console.log("Sartu da");
    console.log(kudeaketaMotaAukeratua.value);
switch (kudeaketaMotaAukeratua.value) {
    case "Guztiak":
        kudeaketaMotaAukeratua.style.color = "black";
        break;
    case "gehitu":
        kudeaketaMotaAukeratua.style.color = "rgb(1, 149, 151)";
        break;
    case "editatu":
        kudeaketaMotaAukeratua.style.color = "#a27014";
        break;
    case "ezabatu":
        kudeaketaMotaAukeratua.style.color = "#1e3a8a";
}
};

//---------------------------------------------------------------------------
//----------------------HISTORIKOA BILAKETAK GELAK---------------------------
//---------------------------------------------------------------------------

// const gailuakGelaHistoriokoa = document.querySelector("#selektGelaHistorikoa");
// gailuakGelaHistoriokoa.addEventListener("change", bilatuGailuaGela);

// const gailuakGailuaHistoriokoa = document.querySelector("#selektGailuaHistorikoa");
// gailuakGailuaHistoriokoa.addEventListener("change", bilatuGailuaGela);

// function bilatuGailuaGela(){
//     const gelaHistorikoa=gailuakGelaHistoriokoa.value;
//     const gailuaHistorikoa=gailuakGailuaHistoriokoa.value;
   
//     const errenkadakEgon=document.querySelectorAll("#egonTaula tbody tr");



//     //Egon taulako errenkada bakoitza aztertu
//     errenkadakEgon.forEach(errenkada =>{
//         let gelaIkusgai=false;
//         let gailuaIkusgai=false;
        
//         //Gela
//         const errenkadakoID=errenkada.querySelector(".tdIdGela");
//         if (gelaHistorikoa==="Guztiak" || gelaHistorikoa===errenkadakoID.textContent){
//             gelaIkusgai=true;
//             console.log("sartu da");
//         }
//         //Gailua
//         const errenkadakoID=errenkada.querySelector(".tdIdGailua");
//         if (gela==="Guztiak" || gailua===errenkadakoID.textContent){
//             gailuaIkusgai=true;
//         }
        
//         if (gelaIkusgai && gailuaIkusgai){
//             errenkada.style.display="";
//         }else{
//             errenkada.style.display="none";
//         }
//     });
// }

//------------------------------ERABILTZAILEAK----------------------------
//------------------------------------------------------------------------
// Erabiltzaileen taulan, Rola zutabean bereiztu aukera ezberdinak:
const erabiltzaileaTaulaTDRola= document.querySelectorAll(".tdRola");
erabiltzaileaTaulaTDRola.forEach(item => {
    switch (item.textContent) {
        case "admin":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "arrunta":
            item.style.color = "#a27014";
    }
});


// admin edo arrunta pantailak eguneratzean, aurkitzen zeneko erlaitzean manten dadin:
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx
// // Detectar el hash en la URL y activar la pestaña correspondiente
// document.addEventListener('DOMContentLoaded', function() {
//    // Función para activar una pestaña por su ID
//     function activateTab(tabId) {
//         // Buscar el botón de la pestaña
//         const tabButton = document.querySelector(`button[data-bs-target="${tabId}"]`);
        
//         if (tabButton) {
//             // Usar Bootstrap para activar la pestaña
//             const bsTab = new bootstrap.Tab(tabButton);
//             bsTab.show();
//         }
//     }
    
//     // Verificar si hay hash en la URL al cargar
//     const hash = window.location.hash;
//     if (hash) {
//         // Quitar el '#' del hash
//         const tabId = hash.substring(1);
//         activateTab('#' + tabId);
//     }
    
//     // Opcional: cuando se cambie de pestaña, actualizar el hash en la URL
//     const tabButtons = document.querySelectorAll('button[data-bs-toggle="pill"]');
//     tabButtons.forEach(button => {
//         button.addEventListener('shown.bs.tab', function(event) {
//             const targetId = event.target.getAttribute('data-bs-target');
//             // Actualizar el hash en la URL sin recargar la página
//             history.pushState(null, null, targetId);
//         });
//     });
// });
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx


//---------------------
// Formularioa balidatu
//---------------------
(function() {
    'use strict';
    
    // Obtener todos los formularios con validación de Bootstrap
    var forms = document.querySelectorAll('.needs-validation');
    
    // Prevenir envío si no es válido
    Array.prototype.slice.call(forms).forEach(function(form) {
        form.addEventListener('submit', function(event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
})();
