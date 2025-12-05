//cspell:disable
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import AppBar from "../components/AppBar";
import Footer from "../components/Footer";

export default function EnSavoirPlus() {
  const orange = "#F15927";

  return (
    <div className="animate__animated animate__bounce  animate__delay-2s" style={{ height: '100vh', width: '100vw', overflowX: 'hidden' }}>
      <AppBar />
      <Bouton />

      <div className="container my-5">
        <h1 style={{ color: orange }}><i className="fas fa-info-circle me-2"></i> En savoir plus</h1>
        <p className="lead">
          Cette plateforme vise à promouvoir la souveraineté numérique et l’usage des logiciels libres
          dans les établissements scolaires. Elle propose des scénarios interactifs, des ressources
          pédagogiques et des conseils pratiques pour réduire la dépendance aux Big Tech.
        </p>
        <div className="alert" style={{ backgroundColor: orange, color: "#fff" }}>
          <i className="fas fa-lightbulb me-2"></i>
          Objectif : donner aux élèves et enseignants les moyens d’agir pour un numérique souverain.
        </div>
      </div>

      <Footer />
    </div>
  );
}
