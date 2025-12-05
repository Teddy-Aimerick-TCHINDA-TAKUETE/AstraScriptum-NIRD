import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

export default function APropos() {
    const orange = "#F15927";

    const devs = [
        { name: "BENGONO  Bruno", linkedin: "https://linkedin.com/in/bruno-bengono", github: "https://github.com/Ben-Bruno" },
        { name: "RAHOU Hind", linkedin: "http://linkedin.com/in/hind-rahou", github: "https://github.com/LaHQuiCode" },
        { name: "TCHINDA Teddy", linkedin: "http://linkedin.com/in/teddy-aimerick-tchinda-takuete", github: "https://github.com/Teddy-Aimerick-TCHINDA-TAKUETEhttps://github.com/nom3" }
    ];

    return (
        <div className="animate__animated animate__bounce  animate__delay-2s" style={{ height: '100vh', width: '100vw', overflowX: 'hidden' }}>
            <AppBar />
            <Bouton />

            <div className="container my-5">
                <h1 style={{ color: orange }}><i className="fas fa-users me-2"></i> À propos des développeurs</h1>
                <p className="lead">Voici l’équipe qui a conçu et développé la plateforme AstraScriptum :</p>

                <div className="row g-4">
                    {devs.map((dev, index) => (
                        <div className="col-md-4" key={index}>
                            <div className="card shadow-sm h-100 text-center">
                                <div className="card-body">
                                    <h5 className="card-title" style={{ color: orange }}>
                                        <i className="fas fa-user me-2"></i>{dev.name}
                                    </h5>
                                    <p>
                                        <a href={dev.linkedin} target="_blank" rel="noopener noreferrer" className="btn btn-outline-primary me-2">
                                            <i className="fab fa-linkedin"></i> LinkedIn
                                        </a>
                                        <a href={dev.github} target="_blank" rel="noopener noreferrer" className="btn btn-outline-dark">
                                            <i className="fab fa-github"></i> GitHub
                                        </a>
                                    </p>
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
