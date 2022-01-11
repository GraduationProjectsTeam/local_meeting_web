import { useState } from "react";
import Modal from "./Modal";

const AppHeader = () => {
  const [showModal, setShowModal] = useState(false);

  return (
    <header className="app__header">
      {showModal ? <Modal onClose={setShowModal} /> : null}
      <h1 className="app__title">
        {/* <Link to="/"> */}
        Информационный портал
        {/* </Link> */}
      </h1>
      <div className="app__buttons">
        <button
          className="button button-register "
          onClick={() => setShowModal(true)}
        >
          Личный кабинет
        </button>
        <button className="button">Добавить мероприятие</button>
      </div>
    </header>
  );
};

export default AppHeader;
