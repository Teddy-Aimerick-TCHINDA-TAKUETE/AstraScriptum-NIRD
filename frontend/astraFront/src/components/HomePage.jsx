//cspell:disable
import React from "react";
import "../style/components/HomePage.scss"

export default function HomePage() {
    return (
        <div className="home-container">

            {/* HERO SECTION */}
            <section className="hero-section d-flex align-items-center">
                <div className="container text-center">
                    <h1 className="hero-title">
                        <i className="fas fa-shield-alt me-3"></i>
                        AstraScriptum – Simulateur NIRD
                    </h1>

                    <p className="hero-subtitle">
                        Construis un établissement numérique souverain, affronte les Big Tech,
                        et deviens un véritable Résistant du Numérique.
                    </p>

                    <div className="hero-buttons mt-4">
                        <a href="/presentation" className="btn btn-primary btn-lg me-3">
                            <i className="fas fa-play me-2"></i>Conseils pratiques
                        </a>
                        <a href="/connexion" className="btn btn-primary btn-lg me-3">
                            <i className="fas fa-play me-2"></i>Démarrer la Simulation
                        </a>
                        <a href="/ressources" className="btn btn-outline-light btn-lg">
                            <i className="fas fa-book me-2"></i>Ressources
                        </a>
                        <a href="/dashboard" className="btn btn-success btn-lg mt-3">
                            <i className="fas fa-arrow-circle-right me-2"></i>Voir le dashboard
                        </a>
                    </div>
                </div>
            </section>

            {/* FEATURES SECTION */}
            <section className="features-section container py-5">
                <h2 className="section-title text-center mb-5">
                    <i className="fas fa-bolt me-2"></i>Fonctionnalités
                </h2>

                <div className="row g-4">

                    <div className="col-md-4">
                        <div className="feature-card p-4 text-center">
                            <i className="fas fa-brain feature-icon"></i>
                            <h4>Intelligence Artificielle</h4>
                            <p>
                                Notre IA analyse tes choix et te propose des stratégies pour améliorer
                                la souveraineté numérique .
                            </p>
                        </div>
                    </div>

                    <div className="col-md-4">
                        <div className="feature-card p-4 text-center">
                            <i className="fas fa-laptop-code feature-icon"></i>
                            <h4>Simulation Interactive</h4>
                            <p>
                                Prends des décisions critiques : migration Linux, reconditionnement,
                                adoption de logiciels libres ...
                            </p>
                        </div>
                    </div>

                    <div className="col-md-4">
                        <div className="feature-card p-4 text-center">
                            <i className="fas fa-users feature-icon"></i>
                            <h4>Public Varié</h4>
                            <p>
                                Élèves, familles, enseignants et collectivités — chacun a son rôle
                                dans le processus de transformation numérique de nos ecoles.
                            </p>
                        </div>
                    </div>

                </div>
            </section>

            {/* CALL TO ACTION */}
            <section className="cta-section text-center">
                <h2>Prêt à défendre la souveraineté numérique ?</h2>
                <p>
                    Lance-toi dans une aventure où stratégie, innovation et résistance s’unissent.
                </p>

            </section>

        </div>
    );
}
