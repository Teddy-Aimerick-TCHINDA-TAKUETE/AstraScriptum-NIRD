//cspell:disable
import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

export default function RessourcePage() {
    const orange = "#F15927";

    const ressources = [
        {
            id: 1,
            type: "video",
            title: "Windows 11 : l’alternative des logiciels libres",
            description: "Reportage France 3 Alpes (2 min, octobre 2025)",
            url: "https://video.echirolles.fr/w/hVykGUtRZqRen6eiutqRvQ",
            icon: "fab fa-windows"
        },
        {
            id: 2,
            type: "audio",
            title: "Mises à jour de Windows : le logiciel libre comme solution ?",
            description: "Grand reportage France Inter (4 min, octobre 2025)",
            url: "https://www.radiofrance.fr/franceinter/podcasts/le-grand-reportage-de-france-inter/le-grand-reportage-du-mardi-14-octobre-2025-4136495",
            icon: "fas fa-podcast"
        },
        {
            id: 3,
            type: "video",
            title: "Logiciel obsolète : l’État obligé de jeter des milliers d’ordinateurs ?",
            description: "Reportage France Info (3 min, septembre 2025)",
            url: "https://www.youtube.com/watch?v=76T8oubek-c",
            icon: "fas fa-desktop"
        },
        {
            id: 4,
            type: "video",
            title: "L’Ordinateur Obsolète",
            description: "Vidéo Back Market (1 min)",
            url: "https://www.youtube.com/watch?v=S6GLqkhykmA",
            icon: "fas fa-recycle"
        },
        {
            id: 5,
            type: "article",
            title: "Le projet NIRD au lycée Carnot",
            description: "Article du Café Pédagogique (avril 2025)",
            url: "https://www.cafepedagogique.net/2025/04/27/bruay-labuissiere-voyage-au-centre-du-libre-educatif/",
            icon: "fas fa-newspaper"
        },
        {
            id: 6,
            type: "video",
            title: "Linux, c'est facile !",
            description: "Captation vidéo des élèves du lycée Carnot (5 min)",
            url: "https://tube-numerique-educatif.apps.education.fr/w/3LXem3XK4asbwZa5R1qGkW",
            icon: "fab fa-linux"
        },
        {
            id: 7,
            type: "video",
            title: "Le projet NIRD présenté par les élèves",
            description: "Vidéo du lycée Carnot (4 min)",
            url: "https://tube-numerique-educatif.apps.education.fr/w/pZCnzPKTYX2iF38Qh4ZGmq",
            icon: "fas fa-school"
        }
    ];

    return (
        <div className="animate__animated animate__bounce  animate__delay-2s" style={{ height: '100vh', width: '100vw', overflowX: 'hidden' }}>
            <AppBar />
            <Bouton />

            {/* Bandeau d’introduction */}
            <div className="text-center p-5" style={{ backgroundColor: orange, color: "#fff" }}>
                <h1><i className="fas fa-book me-2"></i> Ressources NIRD</h1>
                <p>Découvrez les vidéos, audios et articles pour comprendre la souveraineté numérique et le projet NIRD.</p>
            </div>

            {/* Grille des ressources */}
            <div className="container my-5">
                <div className="row g-4">
                    {ressources.map(r => (
                        <div key={r.id} className="col-md-6">
                            <div className="card shadow-sm h-100">
                                <div className="card-body">
                                    <h5 className="card-title" style={{ color: orange }}>
                                        <i className={`${r.icon} me-2`}></i>{r.title}
                                    </h5>
                                    <p className="card-text">{r.description}</p>

                                    {/* Affichage selon type */}
                                    {r.type === "video" && (
                                        <div className="ratio ratio-16x9">
                                            <iframe
                                                src={r.url}
                                                title={r.title}
                                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                                allowFullScreen
                                            ></iframe>
                                        </div>
                                    )}
                                    {r.type === "audio" && (
                                        <div className="mt-3">
                                            <a href={r.url} target="_blank" rel="noopener noreferrer" className="btn" style={{ backgroundColor: orange, color: "#fff" }}>
                                                <i className="fas fa-headphones me-2"></i> Écouter l’audio
                                            </a>
                                        </div>
                                    )}
                                    {r.type === "article" && (
                                        <div className="mt-3">
                                            <a href={r.url} target="_blank" rel="noopener noreferrer" className="btn" style={{ backgroundColor: orange, color: "#fff" }}>
                                                <i className="fas fa-external-link-alt me-2"></i> Lire l’article
                                            </a>
                                        </div>
                                    )}
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
