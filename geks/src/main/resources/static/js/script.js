//-----------------------------
// ERABILTZAILEAK
//-----------------------------
// ErabiltzaileRola koloreztatu
// Erabiltzaileen taulan, Rola zutabean bereiztu aukera ezberdinak:
const erabiltzaileaTaulaTDRola = document.querySelectorAll(".tdRola");
erabiltzaileaTaulaTDRola.forEach(item => {
    switch (item.textContent) {
        case "admin":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "arrunta":
            item.style.color = "#a27014";
    }
});




//-----------------------------
// GAILUAK
//-----------------------------
// Gailu elektronikoen taulan, egoera zutabean bereiztu aukera ezberdinak:
const gailuakTaulaTD = document.querySelectorAll(".tdEgoera");
gailuakTaulaTD.forEach(item => {
    switch (item.textContent) {
        case "erabilgarri":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "esleitua":
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
        case "esleitua":
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

function gailuEgoeraKoloreaJarri() {
    switch (gailuakEgoeraAukeratua.value) {
        case "Guztiak":
            gailuakEgoeraAukeratua.style.color = " rgb(0, 0, 0)";
            break;
        case "erabilgarri":
            gailuakEgoeraAukeratua.style.color = "rgb(1, 149, 151)";
            break;
        case "esleitua":
            gailuakEgoeraAukeratua.style.color = "#da070a";
            break;
        case "mantenuan":
            gailuakEgoeraAukeratua.style.color = "#a27014";
            break;
        case "bajan":
            gailuakEgoeraAukeratua.style.color = "#1e3a8a";
    }
};

//-----------------------------
// Gailuak FILTROAK
//-----------------------------
const gailuakMota = document.querySelector("#selektMota");
gailuakMota.addEventListener("change", bilatuGailua);
gailuakEgoeraAukeratua.addEventListener("change", bilatuGailua);
const gailuakGela = document.querySelector("#selektGela");
gailuakGela.addEventListener("change", bilatuGailua);
const gailuakBilatu = document.querySelector("#bilatuGailua");
gailuakBilatu.addEventListener("input", bilatuGailua);

function bilatuGailua() {
    const mota = gailuakMota.value;
    const egoera = gailuakEgoeraAukeratua.value;
    const gela = gailuakGela.value;
    const gakoa = gailuakBilatu.value.toLowerCase();

    const errenkadakGailuak = document.querySelectorAll("#gailuakTaula tbody tr");


    //Gailuak taulako errenkada bakoitza aztertu
    errenkadakGailuak.forEach(errenkada => {
        let motaIkusgai = false;
        let egoeraIkusgai = false;
        let gakoaIkusgai = false;
        let gelaIkusgai = false;


        const errenkadakoMota = errenkada.querySelector(".tdMota");
        //Gailu mota
        if (errenkadakoMota && (mota === "Guztiak" || mota === errenkadakoMota.textContent)) {
            motaIkusgai = true;
        }
        //Gailu egoera
        const errenkadakoEgoera = errenkada.querySelector(".tdEgoera");
        if (errenkadakoEgoera && (egoera === "Guztiak" || egoera === errenkadakoEgoera.textContent)) {
            egoeraIkusgai = true;
        }
        //Gailua gakoa
        const errenkadaTextua = errenkada.innerText.toLowerCase();
        if (gakoa === null || errenkadaTextua.includes(gakoa)) {
            gakoaIkusgai = true;
        }
        //Gela
        const errenkadakoGela = errenkada.querySelector(".tdIdGela");
        //Gailu mota
        if (errenkadakoGela && (gela === "Guztiak" || gela === errenkadakoGela.textContent)) {
            gelaIkusgai = true;
        }

        if (motaIkusgai && gakoaIkusgai && egoeraIkusgai && gelaIkusgai) {
            errenkada.style.display = "";
        } else {
            errenkada.style.display = "none";
        }
    });
}


//-----------------------------
// HISTORIKOAK
//-----------------------------
// Kudeaketen taulan, Mota zutabean bereiztu aukera ezberdinak:
const KudeatuTaulaTD = document.querySelectorAll(".tdMotaKudeaketa");
KudeatuTaulaTD.forEach(item => {
    switch (item.textContent) {
        case "gehitu":
            item.style.color = "rgb(1, 149, 151)";
            break;
        case "editatu":
            item.style.color = "#a27014";
            break;
        case "esleitu":
            item.style.color = "#da070a";
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
        case "esleitu":
            item.style.color = "#da070a";
            break;
        case "ezabatu":
            item.style.color = "#1e3a8a";
    }
});

// Kudeaketen selecta egitean (motarekiko) valueri bere kolorea eman
const kudeaketaMotaAukeratua = document.querySelector("#selektKudeaketaMota");
if (kudeaketaMotaAukeratua) {//arrunta.html -an ez dago "#selektKudeaketaMota" eta bestela errorea ematen dau
    kudeaketaMotaAukeratua.addEventListener("change", kudeaketaMotaKoloreaJarri);
}

function kudeaketaMotaKoloreaJarri() {
    switch (kudeaketaMotaAukeratua.value) {
        case "Guztiak":
            kudeaketaMotaAukeratua.style.color = " rgb(0, 0, 0)";
            break;
        case "gehitu":
            kudeaketaMotaAukeratua.style.color = "rgb(1, 149, 151)";
            break;
        case "editatu":
            kudeaketaMotaAukeratua.style.color = "#a27014";
            break;
        case "esleitu":
            kudeaketaMotaAukeratua.style.color = "#da070a";
            break;
        case "ezabatu":
            kudeaketaMotaAukeratua.style.color = "#1e3a8a";
    }
};



///------------------------------
// Historikoak FILTROAK kudeaketa
//-------------------------------
const kudeatuErab = document.querySelector("#selektErab");
if (kudeatuErab) {
    kudeatuErab.addEventListener("change", bilatuKudeaketa);
}
const kudeatuGailua = document.querySelector("#selektGailua");
if (kudeatuGailua) {
    kudeatuGailua.addEventListener("change", bilatuKudeaketa);
}
const kudeatuMota = document.querySelector("#selektKudeaketaMota");
if (kudeatuMota) {
    kudeatuMota.addEventListener("change", bilatuKudeaketa);
}
const kudeaketaBilatu = document.querySelector("#bilatuKudeaketa");
if (kudeaketaBilatu) {
    kudeaketaBilatu.addEventListener("input", bilatuKudeaketa);
}

function bilatuKudeaketa() {
    const erabiltzailea = kudeatuErab.value;
    const gailua = kudeatuGailua.value;
    const mota = kudeatuMota.value;
    const gakoa = kudeaketaBilatu.value.toLowerCase();

    const errenkadakKudeaketak = document.querySelectorAll("#historikoakTaula tbody tr");


    //Gailuak taulako errenkada bakoitza aztertu
    errenkadakKudeaketak.forEach(errenkada => {
        let erabIkusgai = false;
        let gailuaIkusgai = false;
        let gakoaIkusgai = false;
        let motaIkusgai = false;


        const errenkadakoErabiltzailea = errenkada.querySelector(".tdErab");
        //Gailu mota
        if (erabiltzailea === "Guztiak" || erabiltzailea === errenkadakoErabiltzailea.textContent) {
            erabIkusgai = true;
        }
        //Gailu egoera
        const errenkadakoGailua = errenkada.querySelector(".tdGailua");
        if (gailua === "Guztiak" || gailua === errenkadakoGailua.textContent) {
            gailuaIkusgai = true;
        }
        //Gailua gakoa
        const errenkadaTextua = errenkada.innerText.toLowerCase();
        if (gakoa === null || errenkadaTextua.includes(gakoa)) {
            gakoaIkusgai = true;
        }
        //Gela
        const errenkadakoMota = errenkada.querySelector(".tdMotaKudeaketa");
        //Gailu mota
        if (mota === "Guztiak" || mota === errenkadakoMota.textContent) {
            motaIkusgai = true;
        }

        if (erabIkusgai && gailuaIkusgai && gakoaIkusgai && motaIkusgai) {
            errenkada.style.display = "";
        } else {
            errenkada.style.display = "none";
        }
    });
}

///------------------------------
// Historikoak FILTROAK Egon
//-------------------------------
const egonGailua = document.querySelector("#selektGailuaHistorikoa");
if (egonGailua) {
    egonGailua.addEventListener("change", bilatuGailuaGela);
}
const egonGela = document.querySelector("#selektGelaHistorikoa");
if (egonGela) {
    egonGela.addEventListener("change", bilatuGailuaGela);
}

function bilatuGailuaGela() {
    const gailuaEgonHistorikoan = egonGailua.value;
    const gelaEgonHistorikoan = egonGela.value;

    const errenkadakKudeaketak = document.querySelectorAll("#egonTaula tbody tr");


    //Gailuak taulako errenkada bakoitza aztertu
    errenkadakKudeaketak.forEach(errenkada => {
        let gailuaIkusgai = false;
        let gelaIkusgai = false;


        const errenkadakoGela = errenkada.querySelector(".tdIdGela");
        //Gailu mota
        if (gelaEgonHistorikoan === "Guztiak" || gelaEgonHistorikoan === errenkadakoGela.textContent) {
            gelaIkusgai = true;
        }
        //Gailu egoera
        const errenkadakoGailua = errenkada.querySelector(".tdIdGailua");
        if (gailuaEgonHistorikoan === "Guztiak" || gailuaEgonHistorikoan === errenkadakoGailua.textContent) {
            gailuaIkusgai = true;
        }

        if (gelaIkusgai && gailuaIkusgai) {
            errenkada.style.display = "";
        } else {
            errenkada.style.display = "none";
        }
    });
}





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
//Sartu beharreko guztia sartu dela konprobatzen da
(function () {
    'use strict';

    // Obtener todos los formularios con validación de Bootstrap
    var forms = document.querySelectorAll('.needs-validation');

    // Prevenir envío si no es válido
    Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    });
})();



//---------------------
// Gailua ezabatu
//---------------------
// const gailuaEzabatuBotoia=document.querySelector("#btnEzabatuGaiua");
// gailuaEzabatuBotoia.addEventListener("click", ezabatuGailua);

// function ezabatuGailua(){
//     alert("Ziur ezabatu nahi duzula?");
// }

//--------------------------------
// Gailua Update formularioa osatu
//--------------------------------
function gailuUpdateDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idGailuaUpdate");
    const marka = document.querySelector("#markaGailuaUpdate");
    const modeloa = document.querySelector("#modeloaGailuaUpdate");
    const serieZenb = document.querySelector("#serieZenbGailuaUpdate");
    const mota = document.querySelector("#motaGailuaUpdate");
    const egoera = document.querySelector("#egoeraGailuaUpdate");
    const idGela = document.querySelector("#idGelaUpdate");

    id.value = tds[0].textContent;
    marka.value = tds[1].textContent;
    modeloa.value = tds[2].textContent;
    serieZenb.value = tds[3].textContent;
    mota.value = tds[4].textContent;
    egoera.value = tds[5].textContent;
    idGela.value = tds[8].textContent;
}

function gailuGelaAldatuDa() {

    //erabiltzaileak sartutako gelako id-a
    const gelaInput = document.querySelector("#idGelaUpdate");
    const gelaIda = gelaInput.value;
    //existitzen diren gela id guztiak
    const gelenIdak = document.querySelectorAll(".tdIdGelaGelaTaula");

    //Gailuaren egoera gordetzen deneko inputa, gelaren balioen arabera modifikatu beharko da
    const gailuEgoeraInput = document.querySelector("#egoeraGailuaUpdate");


    if (gelaIda == "") {
        if (gailuEgoeraInput.value === "esleitua") {
            gailuEgoeraInput.value = "erabilgarri";
            alert("Gailu elektronikoa erabilgarri geratuko da!");
        } else {
            if (gailuEgoeraInput.value === "mantenuan") { alert("Gailu elektronikoa mantenuan geratuko da!"); }
        }
    } else {
        let gelaOk = false;
        for (const item of gelenIdak) {
            if (gelaIda === item.textContent) {
                gelaOk = true;
                break;
            }
        }
        if (gelaOk) {
            if (gailuEgoeraInput.value === "mantenuan") {
                if (!confirm("Gailuak mantenuan jarraitzen du?")) {
                    gailuEgoeraInput.value = "esleitua";
                    alert("Gailu elektronikoa esleituta!");
                }
            } else { gailuEgoeraInput.value = "esleitua"; alert("Gailu elektronikoa esleituta!"); }
        }
        else {
            alert("Kontuz gela hau ez dago sisteman!");
            gelaInput.value = "";
            if (gailuEgoeraInput.value === "esleitua") {
                gailuEgoeraInput.value = "erabilgarri";
                alert("Gailu elektronikoa erabilgarri geratuko da!");
            }
        }
    }
}

function gailuEgoeraAldatuDa() {
    const gailuEgoeraInput = document.querySelector("#egoeraGailuaUpdate");

    switch (gailuEgoeraInput.value) {
        case "erabilgarri":
            document.querySelector("#idGelaUpdate").value = "";
            break;
        case "esleitua":
            const gela = prompt("Ze gelatara egokituko da?");
            document.querySelector("#idGelaUpdate").value = gela;
            gailuGelaAldatuDa();
    }
}

//--------------------------------
// Gailua Delete formularioa osatu
//--------------------------------
function gailuDeleteGatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idGailuaDelete");
    const marka = document.querySelector("#markaGailuaDelete");
    const modeloa = document.querySelector("#modeloaGailuaDelete");
    const serieZenb = document.querySelector("#serieZenbGailuaDelete");
    const mota = document.querySelector("#motaGailuaDelete");
    const egoera = document.querySelector("#egoeraGailuaDelete");
    const idGela = document.querySelector("#idGelaDelete");

    id.value = tds[0].textContent;
    marka.value = tds[1].textContent;
    modeloa.value = tds[2].textContent;
    serieZenb.value = tds[3].textContent;
    mota.value = tds[4].textContent;
    egoera.value = tds[5].textContent;
    idGela.value = tds[8].textContent;
}
