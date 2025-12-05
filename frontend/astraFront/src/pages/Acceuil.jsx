//cspell:disable
import { NavLink } from "react-router-dom";
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";
import Texte from "../components/Texte";



//cspell:disable
const Acceuil = () => {
    return (
        <div style={{ height: '120vh', width: '100vw', overflowX: 'hidden' }}>
            <AppBar />
            <Bouton />
            <Texte />
            <Footer />
        </div>
    );
};
export default Acceuil;