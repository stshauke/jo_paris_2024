// auth.js
function verifierConnexionOuRediriger() {
    const emailVisiteur = localStorage.getItem("emailVisiteur");
    const jwtToken = localStorage.getItem("jwtToken");
    if (!emailVisiteur || !jwtToken) {
        alert("Vous devez être connecté.");
        window.location.href = "/connexion";
        return false;
    }

    return true;
}
