//cspell:disable
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Acceuil from "./pages/Acceuil";
import AnimatedPage from "./pages/AnimatedPage";
import ScenarioPage from "./pages/ScenarioPage";
import RessourcePage from "./pages/RessourcesPages";


const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/acceuil' element={<Acceuil />}></Route>
                <Route path='/Presentation' element={<AnimatedPage />}></Route>
                <Route path='/demarrer' element={<ScenarioPage />}></Route>
                <Route path='/ressources' element={<RessourcePage />}></Route>


            </Routes>
        </BrowserRouter>
    );
};
export default App;