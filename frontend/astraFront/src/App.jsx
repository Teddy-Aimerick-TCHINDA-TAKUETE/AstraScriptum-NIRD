//cspell:disable
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Acceuil from "./pages/Acceuil";


const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/acceuil' element={<Acceuil />}></Route>

            </Routes>
        </BrowserRouter>
    );
};
export default App;