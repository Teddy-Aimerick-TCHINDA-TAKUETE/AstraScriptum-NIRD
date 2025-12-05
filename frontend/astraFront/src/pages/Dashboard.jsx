//cspell:disable
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import { Bar, Line, Pie } from 'react-chartjs-2';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    LineElement,
    PointElement,
    ArcElement,
    Title,
    Tooltip,
    Legend
} from 'chart.js';
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    LineElement,
    PointElement,
    ArcElement,
    Title,
    Tooltip,
    Legend
);

export default function Dashboard() {
    const orange = "#F15927";

    // Données factices
    const userStats = {
        labels: ["Jan", "Fév", "Mar", "Avr", "Mai"],
        datasets: [
            {
                label: "Nouveaux utilisateurs",
                data: [50, 75, 120, 90, 150],
                backgroundColor: orange
            }
        ]
    };

    const scoreStats = {
        labels: ["Scénario 1", "Scénario 2", "Scénario 3", "Scénario 4"],
        datasets: [
            {
                label: "Score moyen",
                data: [65, 80, 72, 90],
                borderColor: orange,
                backgroundColor: "rgba(241,89,39,0.3)"
            }
        ]
    };

    const usageStats = {
        labels: ["Linux", "Windows", "MacOS"],
        datasets: [
            {
                label: "Répartition des systèmes",
                data: [45, 35, 20],
                backgroundColor: [orange, "#333", "#888"]
            }
        ]
    };

    return (
        <div className="animate__animated animate__bounce  animate__delay-2s" style={{ height: '100vh', width: '100vw', overflowX: 'hidden' }}>
            <AppBar />
            <Bouton />

            <div className="container my-5">
                <h1 style={{ color: orange }}>
                    <i className="fas fa-chart-line me-2"></i> Tableau de bord
                </h1>
                <p className="lead">Visualisez les statistiques clés de la plateforme AstraScriptum.</p>

                <div className="row g-4 mt-4">
                    {/* Carte utilisateurs */}
                    <div className="col-md-4">
                        <div className="card shadow-sm text-center">
                            <div className="card-body">
                                <h5 className="card-title" style={{ color: orange }}>
                                    <i className="fas fa-users me-2"></i> Utilisateurs actifs
                                </h5>
                                <h2>1 245</h2>
                                <p className="text-muted">+15% ce mois</p>
                            </div>
                        </div>
                    </div>

                    {/* Carte scénarios */}
                    <div className="col-md-4">
                        <div className="card shadow-sm text-center">
                            <div className="card-body">
                                <h5 className="card-title" style={{ color: orange }}>
                                    <i className="fas fa-gamepad me-2"></i> Scénarios complétés
                                </h5>
                                <h2>320</h2>
                                <p className="text-muted">+8% ce mois</p>
                            </div>
                        </div>
                    </div>

                    {/* Carte score */}
                    <div className="col-md-4">
                        <div className="card shadow-sm text-center">
                            <div className="card-body">
                                <h5 className="card-title" style={{ color: orange }}>
                                    <i className="fas fa-star me-2"></i> Score moyen
                                </h5>
                                <h2>78%</h2>
                                <p className="text-muted">+5% ce mois</p>
                            </div>
                        </div>
                    </div>
                </div>

                {/* Graphiques */}
                <div className="row g-4 mt-4">
                    <div className="col-md-6">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h5 className="card-title" style={{ color: orange }}>
                                    <i className="fas fa-user-plus me-2"></i> Nouveaux utilisateurs
                                </h5>
                                <Bar data={userStats} />
                            </div>
                        </div>
                    </div>

                    <div className="col-md-6">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h5 className="card-title" style={{ color: orange }}>
                                    <i className="fas fa-star-half-alt me-2"></i> Score moyen par scénario
                                </h5>
                                <Line data={scoreStats} />
                            </div>
                        </div>
                    </div>

                    <div className="col-md-6">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <h5 className="card-title" style={{ color: orange }}>
                                    <i className="fas fa-laptop me-2"></i> Répartition des systèmes
                                </h5>
                                <Pie data={usageStats} />
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <Footer />
        </div>
    );
}
