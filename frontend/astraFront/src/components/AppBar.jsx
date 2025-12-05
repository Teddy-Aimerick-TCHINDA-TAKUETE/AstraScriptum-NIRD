
import { Link } from "react-router-dom";

//cspell:disable
const AppBar = () => {

    return (
        <div className="conteneur" >

            <div className="appbar" >
                <header>
                    <div className="logo">
                        <Link to="/acceuil" className="text-decoration-none" style={{ color: 'inherit' }}>
                            <i className="fas fa-home fa-2x"></i> PLATEFORME DU NIRD
                        </Link>

                    </div>
                    <p>ASTRASCRIPTUM</p>
                </header>
            </div>
        </div>
    );
};
export default AppBar;