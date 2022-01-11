import { useState, useEffect, useRef } from "react";

import ErrorMessage from "./ErrorMessage";
import Spinner from "./Spinner";
import holder from "../resources/img/no-photos.png";
import useService from "../services/Service";
import "../style/style.scss";

const EventsList = (props) => {
  const [eventsList, setEventsList] = useState([]);
  const [newItemLoading, setNewItemLoading] = useState(false);
  const [offset, setOffset] = useState(220);
  const [eventsEnded, setEventsEnded] = useState(false);

  const { loading, error, getAllEvents } = useService();

  useEffect(() => {
    onRequest(offset, true);
  }, []);

  const onRequest = (offset, initial) => {
    initial ? setNewItemLoading(false) : setNewItemLoading(true);

    getAllEvents(offset).then(onEventsListLoaded);
  };

  const onEventsListLoaded = (newEventsList) => {
    let ended = false;
    if (newEventsList.length < 6) {
      ended = true;
    }

    setEventsList((eventsList) => [...eventsList, ...newEventsList]);
    setNewItemLoading(false);
    setOffset((offset) => offset + 6);
    setEventsEnded(ended);
  };
  const itemRefs = useRef([]);
  const focusOnItem = (id) => {
    itemRefs.current.forEach((item) =>
      item.classList.remove("events__item_selected")
    );
    itemRefs.current[id].classList.add("events__item_selected");
    itemRefs.current[id].focus();
  };

  const renderItems = (arr) => {
    const items = arr.map((item, i) => {
      let imgStyle = { objectFit: "cover" };
      if (
        item.thumbnail ===
        "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg"
      ) {
        imgStyle = { objectFit: "unset" };
      }
      return (
        <li
          className="events__item"
          key={item.id}
          ref={(el) => (itemRefs.current[i] = el)}
          tabIndex={0}
          onClick={() => {
            props.onEventSelected(item.id);
            focusOnItem(i);
          }}
          onKeyPress={(e)=>{
            if (e.key === " " || e.key === "Enter") {
              props.onEventSelected(item.id);
              focusOnItem(i);
            }
          }}
        >
          <img
            src={item.thumbnail}
            alt={item.title}
            style={imgStyle}
            className="events__item-img"
          />

          <div className="events__item-info">
            <h4 className="events__item-title">{item.title}</h4>
            <p className="events__item-description">{item.short_description}</p>
          </div>
          {/* </Link> */}
        </li>
      );
    });
    return <ul className="events__container">{items}</ul>;
  };

  const items = renderItems(eventsList);
  const errorMessage = error ? <ErrorMessage /> : null;
  const spinner = loading && newItemLoading ? <Spinner /> : null;
  return (
    <div className="events__list">
      {errorMessage}
      {spinner}
      {items}
      <button
        disabled={newItemLoading}
        onClick={() => onRequest(offset)}
        style={{ display: eventsEnded ? "none" : "block" }}
        className="button events__button"
      >
        Показать ещё
      </button>
    </div>
  );
};

export default EventsList;
