//cspell:disable
import { Link } from "react-router-dom";
import logoK from "../assets/img/logoK.png";

const AppBar = () => {
    return (
        <div className="conteneur">
            <div className="appbar">
                <header className="d-flex justify-content-between align-items-center p-3">
                    <div className="logo d-flex align-items-center">
                        <Link to="/acceuil" className="text-decoration-none me-3" style={{ color: 'inherit' }}>
                            <i className="fas fa-home fa-2x me-2"></i> PLATEFORME DU NIRD
                        </Link>
                        {/* Logo rotatif */}
                        <img
                            src={logoK}
                            alt="Logo NIRD rotatif"
                            style={{
                                width: "60px",
                                height: "60px",
                                animation: "spin 5s linear infinite"
                            }}
                        />
                        {/* Logo vertical */}
                        <img
                            src={logoK}
                            alt="Logo NIRD vertical"
                            style={{
                                width: "60px",
                                height: "60px",
                                animation: "upDown 2s ease-in-out infinite"
                            }}
                        />
                    </div>
                    <p className="fw-bold">ASTRASCRIPTUM</p>
                </header>

                {/* Styles fusionnés */}
                <style>
                    {`
                        @keyframes spin {
                          from { transform: rotate(0deg); }
                          to   { transform: rotate(360deg); }
                        }

                        @keyframes upDown {
                          0%   { transform: translateY(0); }
                          50%  { transform: translateY(-20px); }
                          100% { transform: translateY(0); }
                        }
                    `}
                </style>
            </div>
        </div>
    );
};

export default AppBar;
