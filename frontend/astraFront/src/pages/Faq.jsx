//cspell:disable
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

export default function Faq() {
  const orange = "#F15927";

  const questions = [
    {
      q: "Pourquoi utiliser des logiciels libres ?",
      a: "Ils garantissent transparence, indépendance et sécurité, tout en réduisant les coûts."
    },
    {
      q: "Comment accéder aux scénarios interactifs ?",
      a: "Depuis le menu principal, cliquez sur 'Démarrer' pour lancer les scénarios."
    },
    {
      q: "Le projet NIRD est-il ouvert à tous ?",
      a: "Oui, il est conçu pour être partagé et étendu à tous les établissements scolaires."
    }
  ];

  return (
    <div className="animate__animated animate__bounce  animate__delay-2s" style={{ height: '100vh', width: '100vw', overflowX: 'hidden' }}>
      <AppBar />
      <Bouton />

      <div className="container my-5">
        <h1 style={{ color: orange }}><i className="fas fa-question-circle me-2"></i> FAQ</h1>
        <div className="accordion" id="faqAccordion">
          {questions.map((item, index) => (
            <div className="accordion-item" key={index}>
              <h2 className="accordion-header" id={`heading${index}`}>
                <button className="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target={`#collapse${index}`}>
                  {item.q}
                </button>
              </h2>
              <div id={`collapse${index}`} className="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                <div className="accordion-body">
                  {item.a}
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>

      <Footer />
    </div>
  );
}
