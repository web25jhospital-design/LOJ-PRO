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
        //Gailua ze gelatan
        if (gelaEgonHistorikoan === "Guztiak" || gelaEgonHistorikoan === errenkadakoGela.textContent) {
            gelaIkusgai = true;
        }
        //Gailua bilaketa
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


///------------------------------
// GELA FILTROAK
//-------------------------------

const eraikinaGelanInput = document.querySelector("#selektEraikina");
if (eraikinaGelanInput) {
    eraikinaGelanInput.addEventListener("change", bilatuGelaTaulan);
}
const bilatuGelanInput = document.querySelector("#bilatuGela");
if (bilatuGelanInput) {
    bilatuGelanInput.addEventListener("input", bilatuGelaTaulan);
}

function bilatuGelaTaulan() {
    const eraikina = eraikinaGelanInput.value;
    const gakoa = bilatuGelanInput.value.toLowerCase();


    const errenkadakGelak = document.querySelectorAll("#gelakTaula tbody tr");


    //Gailuak taulako errenkada bakoitza aztertu
    errenkadakGelak.forEach(errenkada => {
        let eraikinaIkusgai = false;
        let gakoaIkusgai = false;


        const errenkadakoEraikina = errenkada.querySelector(".tdEraikina");
        //Eraikina
        if (eraikina === "Guztiak" || eraikina === errenkadakoEraikina.textContent) {
            eraikinaIkusgai = true;
        }
        //Gela gakoa
        const errenkadaTextua = errenkada.innerText.toLowerCase();
        if (gakoa === null || errenkadaTextua.includes(gakoa)) {
            gakoaIkusgai = true;
        }


        if (eraikinaIkusgai && gakoaIkusgai) {
            errenkada.style.display = "";
        } else {
            errenkada.style.display = "none";
        }
    });
}






//---------------------
// Formularioak balidatu
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





//-------------------------------------------------------------------------------------------------------------
//------------------------------                  MODAL-EN SCRIPT-AK                 --------------------------
//-------------------------------------------------------------------------------------------------------------

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

//------------------------------------------------------------------------------------
// UPDATE GAILUA MODAL
//Formulario barruan gailuGelaAldatu aldatzean, konprobatu sartutako gela egokia dela.
//------------------------------------------------------------------------------------
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


//-------------------------------------------------------------------------------------
// UPDATE GAILUA MODAL
//Formulario barruan gailuEgoeraAldatu aldatzean, konprobatu sartutako gela egokia dela.
//-------------------------------------------------------------------------------------
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

//Gailua aldatzeko abixua eman
function confirmAlertUpdateGailua() { 
    // Gailuaren aldaketaren abixua eman
    alert("Gailuaren datuak aldatu dira!");

    return true; 
}
//Gailua baja emateko konfirmazioa eskatu
function confirmAlertDeleteGailua() {
    if (confirm("Gailua baja emango da!\nZiur zaude?")) {
        return true;
    }
    return false;
}









//---------------------------------------
// Erabiltzailea Update formularioa osatu
//---------------------------------------
function erabiltzaileaUpdateDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idErabiltzaileaUpdate");
    const izena = document.querySelector("#izenaErabUpdate");
    const abizena = document.querySelector("#abizenaErabUpdate");
    const erabizena = document.querySelector("#erabizenaErabUpdatu");
    const pasahitza = document.querySelector("#pasahitzaErabUpdate");
    const rola = document.querySelector("#erabrolaErabUpdate");

    id.value = tds[0].textContent;
    izena.value = tds[1].textContent;
    abizena.value = tds[2].textContent;
    erabizena.value = tds[3].textContent;
    pasahitza.value = "*********";
    rola.value = tds[4].textContent;
}
//---------------------------------------
// Erabiltzailea Delete formularioa osatu
//---------------------------------------
function erabiltzaileaDeleteDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idErabiltzaileaDelete");
    const izena = document.querySelector("#izenaErabDelete");
    const abizena = document.querySelector("#abizenaErabDelete");
    const erabizena = document.querySelector("#erabizenaErabDelete");
    const pasahitza = document.querySelector("#pasahitzaErabDelete");
    const rola = document.querySelector("#erabrolaErabDelete");

    id.value = tds[0].textContent;
    izena.value = tds[1].textContent;
    abizena.value = tds[2].textContent;
    erabizena.value = tds[3].textContent;
    pasahitza.value = "*********";
    rola.value = tds[4].textContent;
}

//---------------------------------------------------------------------------------------------
// INSERT ERABILTZAILEA MODAL
//Formulario barruan erabiltzaileIzena aldatzean, konprobatu berria iadanik existitzen ez dela.
//---------------------------------------------------------------------------------------------
function erabIzenaAldatuDaInserten() {

    //erabiltzaileak sartutako erabiltzaileizena
    const erabizenaInput = document.querySelector("#erabizenaErabGehitu");
    const erabizena = erabizenaInput.value;
    //existitzen diren erabiltzaileIzen guztiak
    const erabiltzaileenErabIzenak = document.querySelectorAll(".tderabizena");


    if (erabizena != "") {
        erabiltzaileenErabIzenak.forEach(item => {
            if (erabizena === item.textContent) {
                alert("Kontuz, erabiltzaile izen hau iada erabiltzen da!");
                erabizenaInput.value = "";
            }
        })
    }
}
//---------------------------------------------------------------------------------------------
// UPDATE ERABILTZAILEA MODAL
//Formulario barruan erabiltzaileIzena aldatzean, konprobatu berria iadanik existitzen ez dela.
//---------------------------------------------------------------------------------------------
function erabIzenaAldatuDaUpdaten() {

    //erabiltzaileak sartutako erabiltzaileizena
    const erabizenaInput = document.querySelector("#erabizenaErabUpdatu");
    const erabizena = erabizenaInput.value;
    //existitzen diren erabiltzaileIzen guztiak
    const erabiltzaileenErabIzenak = document.querySelectorAll(".tderabizena");


    if (erabizena != "") {
        erabiltzaileenErabIzenak.forEach(item => {
            if (erabizena === item.textContent) {
                alert("Kontuz, erabiltzaile izen hau iada erabiltzen da!");
                erabizenaInput.value = "";
            }
        })
    }
}
//Erabiltzailea aldatzeko abixua eman
function confirmAlertUpdateErabiltzailea() {
    // Erabiltzaile aldaketaren abixua eman
    alert("Erabiltzaile datuak aldatu dira!\nSaioa, aldatutako erabiltzailearena bada, berriz erregistratu beharko zara!");

    return true; 
}
//Erabiltzailea baja emateko konfirmazioa eskatu
function confirmAlertDeleteErabiltzailea() {
    if (confirm("Erabiltzailea baja emango da!\nSaioa, baja emango duzun erabiltzailearena bada, berriz erregistratu beharko zara!\nZiur zaude?")) {
        return true;
    }
    return false;
}



//---------------------------------------------------------------------------------------------
// INSERT GELA MODAL
//Formulario barruan gelaIzena aldatzean, konprobatu berria iadanik existitzen ez dela.
//---------------------------------------------------------------------------------------------
function gelaIzenaAldatuDaInserten() {

    //erabiltzaileak sartutako gelaIzena
    const gelaIzenaInput = document.querySelector("#izenaGelaGehitu");
    const gelaIzena = gelaIzenaInput.value;
    //existitzen diren gelaIzen guztiak
    const gelaIzenak = document.querySelectorAll(".tdgelaIzena");


    if (gelaIzena != "") {
        gelaIzenak.forEach(item => {
            if (gelaIzena === item.textContent) {
                alert("Kontuz, gela izen hau iada erabiltzen da!");
                gelaIzenaInput.value = "";
            }
        })
    }
}
//---------------------------------------------------------------------------------------------
// UPDATE Gela MODAL
//Formulario barruan gelaIzena aldatzean, konprobatu berria iadanik existitzen ez dela.
//---------------------------------------------------------------------------------------------
// function gelaIzenaAldatuDaUpdaten() {

//     //erabiltzaileak sartutako gelaIzena
//     const gelaIzenaInput = document.querySelector("#izenaGelaUpdate");
//     const gelaIzena = gelaIzenaInput.value;
//     //existitzen diren gelaIzen guztiak
//     const gelaIzenak = document.querySelectorAll(".tdgelaIzena");

//     if (gelaIzena != "") {
//         gelaIzenak.forEach(item => {
//             if (gelaIzena === item.textContent) {
//                 alert("Kontuz, gela izen hau iada erabiltzen da!");
//                 gelaIzenaInput.value = "";
//             }
//         })
//     }
// }

//---------------------------------------
// Gela Update formularioa osatu
//---------------------------------------
function gelaUpdateDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");


    const id = document.querySelector("#idGelaUpdate1");
    const eraikina = document.querySelector("#idEraikinaGelaUpdate");
    const izena = document.querySelector("#izenaGelaUpdate");
    const deskribapena = document.querySelector("#deskribapenaGelaUpdate");

    id.value = tds[0].textContent;      // ID Gela
    eraikina.value = tds[1].textContent; // ID Eraikina
    izena.value = tds[2].textContent;    // Izena
    deskribapena.value = tds[3].textContent; // Deskribapena
}
//---------------------------------------
// Gela Delete formularioa osatu
//---------------------------------------
function gelaDeleteDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idGelaDelete1");
    const eraikina = document.querySelector("#idEraikinaGelaDelete");
    const izena = document.querySelector("#izenaGelaDelete");
    const deskribapena = document.querySelector("#deskribapenaGelaDelete");

    id.value = tds[0].textContent;      // ID Gela
    eraikina.value = tds[1].textContent; // ID Eraikina
    izena.value = tds[2].textContent;    // Izena
    deskribapena.value = tds[3].textContent; // Deskribapena
}

//Gela aldatzeko abixua eman
function confirmAlertUpdateGela() { 
    // Gailuaren aldaketaren abixua eman
    alert("Gelaren datuak aldatu dira!");

    return true; 
}
//Gela ezabatzeko konfirmazioa eskatu
function confirmAlertDeleteGela() {
    if (confirm("Gela ezabatu egingo da!\nZiur zaude?")) {
        return true;
    }
    return false;
}




//---------------------------------------
// Eraikina Update formularioa osatu
//---------------------------------------
function eraikinaUpdateDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idEraikinaUpdate");
    const izena = document.querySelector("#izenaEraikinaUpdate");
    const deskribapena = document.querySelector("#deskribapenaEraikinaUpdate");

    id.value = tds[0].textContent;
    izena.value = tds[1].textContent;
    deskribapena.value = tds[2].textContent;
}
//---------------------------------------
// Eraikina Delete formularioa osatu
//---------------------------------------
function eraikinaDeleteDatuakKargatu() {
    const tr = event.target.closest('tr');
    const tds = tr.querySelectorAll("td");

    const id = document.querySelector("#idEraikinaDelete");
    const izena = document.querySelector("#izenaEraikinaDelete");
    const deskribapena = document.querySelector("#deskribapenaEraikinaDelete");

    id.value = tds[0].textContent;
    izena.value = tds[1].textContent;
    deskribapena.value = tds[2].textContent;
}


//---------------------------------------------------------------------------------------------
// INSERT ERAIKINA MODAL
//Formulario barruan gelaIzena aldatzean, konprobatu berria iadanik existitzen ez dela.
//---------------------------------------------------------------------------------------------
function idEraikinaAldatuDaInserten() {

    //erabiltzaileak sartutako gelaIzena
    const eraikinaIdaInput = document.querySelector("#idEraikinaGehitu");
    const eraikinaIda = eraikinaIdaInput.value;
    //existitzen diren gelaIzen guztiak
    const eraikinIdak = document.querySelectorAll(".tdIdEraikina");


    if (eraikinaIda != "") {
        eraikinIdak.forEach(item => {
            if (eraikinaIda === item.textContent.toLowerCase()) {
                alert("Kontuz, eraikin ID hau iada erabiltzen da!");
                eraikinaIdaInput.value = "";
            }
        })
    }
}

//Eraikina aldatzeko abixua eman
function confirmAlertUpdateEraikina() { 
    // Gailuaren aldaketaren abixua eman
    alert("Eraikinaren datuak aldatu dira!");

    return true; 
}
//Eraikina ezabatzeko konfirmazioa eskatu
function confirmAlertDeleteEraikina() {
    if (confirm("Eraikina ezabatu egingo da!\nZiur zaude?")) {
        return true;
    }
    return false;
}




// function confirmAlertDeleteErabiltzailea() {
//     // Erakutsi modal-a
//     var myModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'));
//     myModal.show();
    
//     // Promise bat itzuli (beharrezkoa formularioarekin lan egiteko)
//     return new Promise((resolve) => {
//         // "Bai" botoiaren klik-a
//         document.getElementById('confirmDeleteBtn').onclick = function() {
//             myModal.hide();
//             resolve(true); // return true bezala
//         };
        
//         // Modal-a itxi denean (Ez botoia edo X ikonoa)
//         document.getElementById('confirmDeleteModal').addEventListener('hidden.bs.modal', function() {
//             resolve(false); // return false bezala
//         }, { once: true });
//     });
// }

// async function handleSubmit(event) {
//     // 1. async -> funtzio honek Promise bat itzuliko duela esan nahi du
    
//     event.preventDefault(); // Formularioa berehala ez bidaltzeko
    
//     // 2. await -> itxaron confirmAlertDeleteErabiltzailea() funtzioak erantzun arte
//     // confirmAlertDeleteErabiltzailea()-k itzultzen duen Promise-a ebazten denean,
//     // emaitza (true/false) "confirmed" aldagaian gordetzen da
//     var confirmed = await confirmAlertDeleteErabiltzailea();
    
//     // 3. confirmed true bada (erabiltzaileak "Bai" sakatu du)
//     if (confirmed) {
//         // Formularioa bidali
//         event.target.submit(); // "event.target" da formularioa bera
//     }
//     // confirmed false bada (erabiltzaileak "Ez" sakatu du), ez da ezer gertatzen
// }
