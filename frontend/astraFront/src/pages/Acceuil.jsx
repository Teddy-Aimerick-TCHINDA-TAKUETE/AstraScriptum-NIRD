//cspell:disable
import { NavLink } from "react-router-dom";
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";
import HomePage from "../components/HomePage";



//cspell:disable
const Acceuil = () => {
    return (
        <div style={{ height: '120vh', width: '100vw', overflowX: 'hidden' }}>
            <AppBar />
            <Bouton />
            <HomePage />
            <Footer />
        </div>
    );
};
export default Acceuil;