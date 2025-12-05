//cspell:disable
import { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

export default function AnimatedPage() {
    const [modalContent, setModalContent] = useState(null);

    const openModal = (content) => setModalContent(content);
    const closeModal = () => setModalContent(null);

    return (
        <div className="animate__animated animate__bounce  animate__delay-2s" style={{ height: '100vh', width: '100vw', overflowX: 'hidden' }}>
            <AppBar />
            <Bouton />
            <div className="container py-5 animated-page">
                <h1 className="text-center mb-4 text-orange">Village Numérique Résistant</h1>
                <p className="text-center mb-5">
                    Explorez les fonctionnalités pour comprendre, comparer et agir face aux Big Tech.
                </p>

                <div className="row g-4 justify-content-center">
                    <div className="col-md-3">
                        <button className="feature-btn" onClick={() => openModal("licences")}>
                            <i className="fas fa-balance-scale fa-3x"></i>
                            <p>Comparer les licences</p>
                        </button>
                    </div>

                    <div className="col-md-3">
                        <button className="feature-btn" onClick={() => openModal("windows")}>
                            <i className="fab fa-windows fa-3x"></i>
                            <p>Voir la version de Windows</p>
                        </button>
                    </div>

                    <div className="col-md-3">
                        <button className="feature-btn" onClick={() => openModal("linux")}>
                            <i className="fab fa-linux fa-3x"></i>
                            <p>Installer Linux via clé USB</p>
                        </button>
                    </div>

                    <div className="col-md-3">
                        <button className="feature-btn" onClick={() => openModal("defis")}>
                            <i className="fas fa-gamepad fa-3x"></i>
                            <p>Défis & Jeux</p>
                        </button>
                    </div>
                </div>

                {modalContent && (
                    <div className="modal-overlay" onClick={closeModal}>
                        <div className="modal-box" onClick={(e) => e.stopPropagation()}>
                            <button className="close-btn" onClick={closeModal}>
                                <i className="fas fa-times"></i>
                            </button>

                            {modalContent === "licences" && (
                                <div>
                                    <h2>Comparaison des licences logicielles</h2>
                                    <p>
                                        <strong>Logiciels libres :</strong> ouverts, modifiables, gratuits, respectent vos données.<br />
                                        <strong>Logiciels propriétaires :</strong> fermés, payants, dépendance aux éditeurs.
                                    </p>
                                    <ul>
                                        <li><i className="fas fa-check text-orange"></i> Liberté d’utilisation et de modification</li>
                                        <li><i className="fas fa-check text-orange"></i> Communauté active et transparente</li>
                                        <li><i className="fas fa-times text-orange"></i> Pas de dépendance aux Big Tech</li>
                                    </ul>
                                </div>
                            )}

                            {modalContent === "windows" && (
                                <div>
                                    <h2>Comment vérifier la version de Windows</h2>
                                    <p>
                                        1. Appuyez sur <strong>Win + R</strong>.<br />
                                        2. Tapez <code>winver</code> et validez.<br />
                                        3. Une fenêtre s’ouvre avec la version exacte.<br />
                                        <br />
                                        <i className="fas fa-info-circle text-orange"></i> Utile pour savoir si votre système est encore supporté.
                                    </p>
                                </div>
                            )}

                            {modalContent === "linux" && (
                                <div>
                                    <h2>Installer Linux avec une clé USB bootable</h2>
                                    <p>
                                        Étapes principales :
                                    </p>
                                    <ol>
                                        <li>Téléchargez une distribution Linux (Ubuntu, Mint, Fedora).</li>
                                        <li>Créez une clé USB bootable avec Rufus ou Etcher.</li>
                                        <li>Redémarrez votre PC et entrez dans le BIOS.</li>
                                        <li>Sélectionnez la clé USB comme périphérique de démarrage.</li>
                                        <li>Lancez l’installation et suivez les instructions.</li>
                                    </ol>
                                    <p>
                                        <i className="fas fa-lightbulb text-orange"></i> Conseil : testez d’abord en mode “Live USB” pour essayer Linux sans l’installer.
                                    </p>
                                </div>
                            )}

                            {modalContent === "defis" && (
                                <div>
                                    <h2>Défis & Jeux NIRD</h2>
                                    <p>
                                        Participez à des mini-jeux pour apprendre en vous amusant :
                                    </p>
                                    <ul>
                                        <li><i className="fas fa-puzzle-piece text-orange"></i> Quiz sur la souveraineté numérique</li>
                                        <li><i className="fas fa-laptop-code text-orange"></i> Missions pratiques (installer Linux, tester logiciels libres)</li>
                                        <li><i className="fas fa-medal text-orange"></i> Gagnez des points et badges</li>
                                    </ul>
                                    <p>
                                        <i className="fas fa-users text-orange"></i> Rejoignez la communauté et comparez vos scores avec vos amis.
                                    </p>
                                </div>
                            )}
                        </div>
                    </div>
                )}
            </div>
            <Footer />
        </div>
    );
}
