// cspell:disable
import { useState } from "react";
import { useNavigate, NavLink } from "react-router-dom";
import { useAuth } from "../auth/AuthContext";
import AppBar from "../components/AppBar";
import Bouton from "../components/Bouton";
import Footer from "../components/Footer";

const Inscription = () => {
  const [nom, setNom] = useState("");
  const [mail, setMail] = useState("");
  const [password, setPassword] = useState("");
  const [type, setType] = useState("ELEVE");
  const [erreur, setErreur] = useState("");
  const { register, loading } = useAuth();
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErreur("");

    const result = await register(nom, mail, password, type);
    if (!result.success) {
        setErreur(result.message);
        return;
    }

    navigate("/connexion");
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
            maxWidth: "480px",
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
            Créer un compte
          </h1>

          <form onSubmit={handleSubmit} style={{ display: "grid", gap: "16px" }}>
            <div>
              <label style={{ fontSize: "12px" }}>Nom</label>
              <input
                type="text"
                value={nom}
                onChange={(e) => setNom(e.target.value)}
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

            <div>
              <label style={{ fontSize: "12px" }}>Type d'utilisateur</label>
              <select
                value={type}
                onChange={(e) => setType(e.target.value)}
                style={{
                  width: "100%",
                  padding: "10px 12px",
                  borderRadius: "12px",
                  border: "1px solid #444",
                  backgroundColor: "#000",
                  color: "#fff",
                  marginTop: "6px",
                }}
              >
                <option value="ELEVE">Élève</option>
                <option value="ENSEIGNANT">Enseignant</option>
                <option value="ADMIN">Administrateur</option>
              </select>
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
              {loading ? "Inscription..." : "Créer le compte"}
            </button>
          </form>

          <p style={{ marginTop: "16px", fontSize: "12px", textAlign: "center" }}>
            Déjà un compte ?{" "}
            <NavLink to="/connexion" style={{ color: "#ff5a1f" }}>
              Se connecter
            </NavLink>
          </p>
        </div>
      </main>
      <Footer />
    </div>
  );
};

export default Inscription;
