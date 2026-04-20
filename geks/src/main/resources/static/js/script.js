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
        kudeaketaMotaAukeratua.style.color = "black";
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