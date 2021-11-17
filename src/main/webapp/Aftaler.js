BrugerFremvsinging();
var i = 1;
let json;

function BrugerFremvsinging() {
    let Bruger = sessionStorage.getItem("Godkendt_Bruger");
    document.getElementById("Bruger").innerHTML = Bruger;
}

function AftaleOprettelse(){
    let Dato = document.getElementById("dato").value;
    let StartTid = document.getElementById("tid_fra").value;
    let Sluttid = document.getElementById("tid_til").value;
    let CPR = document.getElementById("CPR").value;
    let SP = document.getElementById("SP").value;
    let Notat = document.getElementById("Notat").value;



    if (Dato != null && StartTid != null && Sluttid != null && CPR.length == 10 && SP != null){
        KonsultationsUdfyldning();
        Bruger = sessionStorage.getItem("Godkendt_Bruger");

        document.getElementById("Dato"+i).innerHTML = Dato;
        document.getElementById("Starttid"+i).innerHTML = StartTid;
        document.getElementById("Sluttid"+i).innerHTML = Sluttid;
        document.getElementById("CPR"+i).innerHTML = CPR;
        document.getElementById("SP"+i).innerHTML = SP;
        document.getElementById("Bruger"+i).innerHTML = Bruger;
        document.getElementById("Notat"+i).innerHTML = Notat;

        i++;
    } else{
        alert("Indtast venligst alle oplsyninger. ")
    }
}

function KonsultationsUdfyldning(){
    var tabel = document.getElementById("Konsultationstabel");
    var raekke = tabel.insertRow(i);

    var Dato = raekke.insertCell(0);
    Dato.id="Dato"+i
    Dato.noWrap= true;

    var Starttid = raekke.insertCell(1);
    Starttid.id="Starttid"+i
    Starttid.noWrap= true;

    var Sluttid = raekke.insertCell(2);
    Sluttid.id="Sluttid"+i
    Sluttid.noWrap= true;

    var CPR = raekke.insertCell(3);
    CPR.id="CPR"+i
    CPR.noWrap= true;

    var SP = raekke.insertCell(4);
    SP.id="SP"+i
    SP.noWrap= true;

    var Bruger = raekke.insertCell(5);
    Bruger.id="Bruger"+i
    Bruger.noWrap= true;

    var Notat = raekke.insertCell(6);
    Notat.style.height='100px'
    var TextArea = document.createElement("TEXTAREA");
    TextArea.style.border= 'none';
    TextArea.style.height= '100px';
    TextArea.style.width= '100%';
    TextArea.style.boxSizing= 'border-box';
    Notat.appendChild(TextArea)
    TextArea.id="Notat"+i
}
async function opretGiraf(form1){
    let KTform = document.getElementById(form1)
    let formData = new FormData(KTform)
    let patientJson = Object.fromEntries(formData);
    let res = await fetch("/it3grp5_war/rest/Aftaler", {
        method: "POST",
        body: JSON.stringify(patientJson),
        headers: {
            'content-type': "application/json"
          }
    })
    alert (res);
    await hentGiraffer();
}


async function hentGiraffer(){
    let result = await fetch("http://localhost:8080/it3grp5_war/rest/Aftaler");
    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    updateGiraffes(json)

}

function updateGiraffes(json) {
    let listelements =""
    json.forEach(function(element){
        listelements += ("<li>"+element.name+"</li>")
    })

    let girafList = document.getElementById("giraffer");
    girafList.innerHTML=listelements
}

