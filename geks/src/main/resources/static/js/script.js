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
            break;
    }
});

selektEgoera
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
            break;
    }
});

const gailuakEgoeraAukeratua = document.querySelector("#selektEgoera");
gailuakEgoeraAukeratua.addEventListener("change", egoeraKoloreaJarri);
console.log("oin SARTU");
function egoeraKoloreaJarri(){
    console.log("Sartu da");
    console.log(gailuakEgoeraAukeratua.value);
switch (gailuakEgoeraAukeratua.value) {
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
        break;
}
};

