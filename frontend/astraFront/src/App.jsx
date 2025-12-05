// cspell:disable
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Acceuil from "./pages/Acceuil";
import AnimatedPage from "./pages/AnimatedPage";
import ScenarioPage from "./pages/ScenarioPage";
import RessourcePage from "./pages/RessourcesPages";
import Connexion from "./pages/Connexion";
import Inscription from "./pages/Inscription";
import { AuthProvider } from "./auth/AuthContext";
import APropos from "./pages/APropos";
import Faq from "./pages/Faq";
import EnSavoirPlus from "./pages/EnSavoirPlus";
import Dashboard from "./pages/Dashboard";

const App = () => {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Routes>
                    <Route path="/acceuil" element={<Acceuil />} />
                    <Route path="/presentation" element={<AnimatedPage />} />
                    <Route path="/demarrer" element={<ScenarioPage />} />
                    <Route path="/ressources" element={<RessourcePage />} />
                    <Route path="/connexion" element={<Connexion />} />
                    <Route path="/inscription" element={<Inscription />} />
                    {/* route par défaut */}
                    <Route path="*" element={<Acceuil />} />
                    <Route path="/about" element={<APropos />} />
                    <Route path="/faq" element={<Faq />} />
                    <Route path="/savoirPlus" element={<EnSavoirPlus />} />

                    <Route path="/dashboard" element={<Dashboard />} />
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
};

export default App;
