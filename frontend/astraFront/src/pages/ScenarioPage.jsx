//cspell:disable
import { useState, useEffect } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import AppBar from "../components/AppBar";
import village from "../assets/img/village.png";
import gaulois from "../assets/img/gaulois.png";


export default function ScenarioPage() {
    const [score, setScore] = useState(10);
    const [message, setMessage] = useState("");
    const [showPopup, setShowPopup] = useState(false);

    const orange = "#F15927";

    const handleAnswer = (isCorrect, recommendation) => {
        if (isCorrect) {
            setScore(prev => prev + 5);
            setMessage(`✅ Bravo ! ${recommendation}`);
        } else {
            setScore(prev => prev - 3);
            setMessage(`❌ Attention ! ${recommendation}`);
        }
        setShowPopup(true);
    };

    const speakIntro = () => {
        const utterance = new SpeechSynthesisUtterance(
            "Salut ! Libère ton établissement de la dépendance aux Big Tech en réalisant ces scénarios interactifs."
        );
        utterance.lang = "fr-FR";
        speechSynthesis.cancel();
        speechSynthesis.speak(utterance);
    };

    useEffect(() => {
        if (showPopup) {
            const timer = setTimeout(() => setShowPopup(false), 4000);
            return () => clearTimeout(timer);
        }
    }, [showPopup]);

    return (
        <div style={{ height: '100vh', width: '100vw', overflowX: 'hidden', position: 'relative' }}>
            <AppBar />
            <Bouton />

            {/* Image de fond */}
            <div style={{

                backgroundImage: 'url(${village})',
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                position: 'fixed',
                top: 0, left: 0,
                width: '100%', height: '100%',
                zIndex: -1,
                filter: 'brightness(0.85)'
            }}></div>
            <div style={{ backgroundImage: `url(${village})` }}></div>

            {/* Personnage + audio */}
            <div className="d-flex align-items-center m-4">
                <img src={gaulois} alt="Gaulois" style={{ width: '120px', animation: 'bounce 2s infinite' }} />
                <div className="ms-3 p-3 rounded bg-white" style={{ maxWidth: '400px', border: `2px solid ${orange}` }}>
                    <p><strong>Gaulois :</strong> Prêt pour la résistance numérique ?</p>
                    <button className="btn" onClick={speakIntro} style={{ backgroundColor: orange, color: '#fff' }}>
                        <i className="fas fa-volume-up me-2"></i> Écouter le message
                    </button>
                </div>
                <img
                    src={village}
                    alt="Logo"
                    style={{
                        width: '120px',
                        animation: 'bounce 1s infinite',
                        transform: 'rotate(45deg)'
                    }}
                />
            </div>

            {/* Score */}
            <div style={{
                backgroundColor: orange,
                color: '#fff',
                padding: '0.5rem 1rem',
                borderRadius: '999px',
                display: 'inline-block',
                margin: '1rem',
                fontWeight: 'bold'
            }}>
                <i className="fas fa-star me-2"></i> Score : {score}
            </div>

            {/* Salles interactives */}
            <div className="container mt-4">
                <div className="row g-4">
                    {/* Salle des licences */}
                    <div className="col-md-6">
                        <div className="p-4 rounded bg-white text-center" style={{ border: `2px solid ${orange}` }}>
                            <h4><i className="fas fa-balance-scale me-2"></i>Salle des licences</h4>
                            <p>Pourquoi préférer les logiciels libres ?</p>
                            <button className="btn m-2" onClick={() => handleAnswer(true, "Indépendance et transparence gagnées !")}
                                style={{ backgroundColor: orange, color: '#fff' }}>
                                <i className="fas fa-unlock-alt me-2"></i>Indépendance
                            </button>
                            <button className="btn btn-dark m-2" onClick={() => handleAnswer(false, "Les communautés sont une force, pas une faiblesse.")}>
                                <i className="fas fa-users me-2"></i>Trop de communauté
                            </button>
                        </div>
                    </div>

                    {/* Salle des systèmes */}
                    <div className="col-md-6">
                        <div className="p-4 rounded bg-white text-center" style={{ border: `2px solid ${orange}` }}>
                            <h4><i className="fab fa-linux me-2"></i>Salle des systèmes</h4>
                            <p>Quelle action a le plus d’impact ?</p>
                            <button className="btn m-2" onClick={() => handleAnswer(true, "Linux réduit les coûts et améliore la sécurité.")}
                                style={{ backgroundColor: orange, color: '#fff' }}>
                                <i className="fas fa-shield-alt me-2"></i>Passage à Linux
                            </button>
                            <button className="btn btn-dark m-2" onClick={() => handleAnswer(false, "Rester sur Windows augmente la dépendance.")}>
                                <i className="fab fa-windows me-2"></i>Continuer sur Windows
                            </button>
                        </div>
                    </div>

                    {/* Salle des défis */}
                    <div className="col-md-6">
                        <div className="p-4 rounded bg-white text-center" style={{ border: `2px solid ${orange}` }}>
                            <h4><i className="fas fa-gamepad me-2"></i>Salle des défis</h4>
                            <p>Prêt à relever un défi numérique ?</p>
                            <button className="btn m-2" onClick={() => handleAnswer(true, "Bravo ! Tu gagnes un badge NIRD.")}
                                style={{ backgroundColor: orange, color: '#fff' }}>
                                <i className="fas fa-medal me-2"></i>Oui
                            </button>
                            <button className="btn btn-dark m-2" onClick={() => handleAnswer(false, "Tu rates une occasion de progresser.")}>
                                <i className="fas fa-times-circle me-2"></i>Non
                            </button>
                        </div>
                    </div>

                    {/* Salle du cloud */}
                    <div className="col-md-6">
                        <div className="p-4 rounded bg-white text-center" style={{ border: `2px solid ${orange}` }}>
                            <h4><i className="fas fa-cloud me-2"></i>Salle du cloud</h4>
                            <p>Où stocker les données scolaires ?</p>
                            <button className="btn m-2" onClick={() => handleAnswer(true, "Bravo ! Tu choisis un hébergement souverain.")}
                                style={{ backgroundColor: orange, color: '#fff' }}>
                                <i className="fas fa-server me-2"></i>Serveur local ou européen
                            </button>
                            <button className="btn btn-dark m-2" onClick={() => handleAnswer(false, "Attention aux risques de fuite de données.")}>
                                <i className="fab fa-google-drive me-2"></i>Google Drive
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            {/* Popup de recommandation */}
            {showPopup && (
                <div style={{
                    position: 'fixed',
                    top: '50%',
                    left: '50%',
                    transform: 'translate(-50%, -50%)',
                    backgroundColor: orange,
                    color: '#fff',
                    padding: '1rem 2rem',
                    borderRadius: '12px',
                    zIndex: 9999,
                    maxWidth: '600px',
                    textAlign: 'center',
                    boxShadow: '0 0 10px rgba(0,0,0,0.5)'
                }}>
                    <p>{message}</p>
                </div>
            )}


        </div>
    );
}
