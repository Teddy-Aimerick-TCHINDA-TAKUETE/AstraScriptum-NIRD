
import { Link } from "react-router-dom";

//cspell:disable
const AppBar = () => {

    return (
        <div className="conteneur" >

            <div className="appbar" >
                <header>
                    <div className="logo">
                        <Link to="/acceuil" className="text-decoration-none" style={{ color: 'inherit' }}>
                            <i className="fas fa-home fa-2x"></i> BIENVENUE DANS VOTRE BANQUE CREDIT MUTUEL
                        </Link>

                    </div>
                    <p>AGENCE DE LIMOGES</p>
                </header>
            </div>
        </div>
    );
};
export default AppBar;