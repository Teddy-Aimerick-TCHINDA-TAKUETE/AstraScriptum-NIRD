//cspell:disable
import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const Bouton = () => {
  useEffect(() => {

  }, []);
  const navigate = useNavigate();

  const seConnecter = () => {
    navigate("/authentification");
  };
  const faq = () => {
    navigate("/faq");
  }
  const about = () => {
    navigate("/about");
  }
  const dev = () => {
    navigate("/dev");
  }

  return (
    <div className="contenant">
      <div className="bouton-gauche">
        <button
          type="button"
          className="btn btn-secondary anim"
          data-bs-toggle="tooltip"
          data-bs-placement="top"
          data-bs-title="En savoir plus"
          onClick={about}

        >
          En savoir plus
        </button>
        <button
          type="button"
          className="btn btn-secondary anim"
          data-bs-toggle="tooltip"
          data-bs-placement="right"
          data-bs-title="FAQs"
          onClick={faq}

        >
          FAQs
        </button>
        <button
          type="button"
          className="btn btn-secondary anim"
          data-bs-toggle="tooltip"
          data-bs-placement="bottom"
          data-bs-title="A propos des développeurs"
          onClick={dev}
        >
          A propos des développeurs
        </button>
      </div>

      <div className="bouton-droite">
        <button
          type="button"
          className="btn btn-secondary anim"
          data-bs-toggle="tooltip"
          data-bs-placement="left"
          data-bs-title="Se connecter"
          onClick={seConnecter}
        >
          Se connecter
        </button>
      </div>
    </div>
  );
};

export default Bouton;
