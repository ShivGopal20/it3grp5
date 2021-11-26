//NavneFremvsinging();

function NavneFremvsinging() {
   Bruger = sessionStorage.getItem("Godkendt_Bruger");
   document.getElementById("GodkendtBruger").innerHTML = Bruger;

}
