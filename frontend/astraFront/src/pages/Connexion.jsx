// cspell:disable
import { useState } from "react";
import { useLocation, useNavigate, NavLink } from "react-router-dom";
import { useAuth } from "../auth/AuthContext";
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

const Connexion = () => {
  const [mail, setMail] = useState("");
  const [password, setPassword] = useState("");
  const [erreur, setErreur] = useState("");
  const { login, loading } = useAuth();
  const navigate = useNavigate();
  const location = useLocation();
  const from = (location.state && location.state.from) || "/acceuil";

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErreur("");

    const ok = await login(mail, password);
    if (!ok) {
      setErreur("Email ou mot de passe incorrect.");
      return;
    }

    navigate(from, { replace: true });

    // if (from === "/acceuil") {
    //   navigate("/demarrer", { replace: true });
    // } else {
    //   navigate(from, { replace: true });
    // }
  };

  return (
    <div style={{ height: '120vh', width: '100vw', overflowX: 'hidden', backgroundColor: "#000", color: "#fff" }}>
      <AppBar />
      <Bouton />
      <main
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          padding: "40px 16px",
        }}
      >
        <div
          style={{
            backgroundColor: "#111",
            borderRadius: "24px",
            padding: "32px 28px",
            maxWidth: "420px",
            width: "100%",
            boxShadow: "0 0 40px rgba(0,0,0,0.6)",
            border: "2px solid #ff5a1f",
          }}
        >
          <h1
            style={{
              fontFamily: "'Press Start 2P', system-ui, sans-serif",
              fontSize: "18px",
              marginBottom: "24px",
              color: "#ff5a1f",
              textAlign: "center",
            }}
          >
            Se connecter
          </h1>

          <form onSubmit={handleSubmit} style={{ display: "grid", gap: "16px" }}>
            <div>
              <label style={{ fontSize: "12px" }}>Adresse email</label>
              <input
                type="email"
                value={mail}
                onChange={(e) => setMail(e.target.value)}
                required
                style={{
                  width: "100%",
                  padding: "10px 12px",
                  borderRadius: "12px",
                  border: "1px solid #444",
                  backgroundColor: "#000",
                  color: "#fff",
                  marginTop: "6px",
                }}
              />
            </div>

            <div>
              <label style={{ fontSize: "12px" }}>Mot de passe</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
                style={{
                  width: "100%",
                  padding: "10px 12px",
                  borderRadius: "12px",
                  border: "1px solid #444",
                  backgroundColor: "#000",
                  color: "#fff",
                  marginTop: "6px",
                }}
              />
            </div>

            {erreur && (
              <p style={{ color: "#ff7777", fontSize: "12px" }}>{erreur}</p>
            )}

            <button
              type="submit"
              disabled={loading}
              style={{
                marginTop: "8px",
                width: "100%",
                padding: "12px",
                borderRadius: "999px",
                border: "none",
                backgroundColor: "#ff5a1f",
                color: "#fff",
                fontWeight: "bold",
                cursor: "pointer",
              }}
            >
              {loading ? "Connexion..." : "Connexion"}
            </button>
          </form>

          <p style={{ marginTop: "16px", fontSize: "12px", textAlign: "center" }}>
            Pas encore de compte ?{" "}
            <NavLink to="/inscription" style={{ color: "#ff5a1f" }}>
              Créer un compte
            </NavLink>
          </p>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default Connexion;
