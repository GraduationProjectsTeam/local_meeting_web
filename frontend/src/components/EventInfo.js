import { useState, useEffect } from "react";
import ErrorMessage from "./ErrorMessage";
import Spinner from "./Spinner";
import Skeleton from "./Skeleton";
import useService from "../services/Service";
import "../style/style.scss";

const EventInfo = ({eventId}) => {
  const [event, setEvent] = useState(null);
  const { loading, error, getEvent, clearError } = useService();

  useEffect(() => {
    updateEvent();
  }, [ eventId]);

  const updateEvent = () => {
    if (!eventId) {
      return;
    }
    clearError();
    getEvent(eventId).then(onEventLoaded);
  };

  const onEventLoaded = (event) => {
    setEvent(event);
  };
  const skeleton = event || loading || error ? null : <Skeleton />;
  const errorMessage = error ? <ErrorMessage /> : null;
  const spinner = loading ? <Spinner /> : null;
  const content = !(error || loading || !event) ? <View event={event} /> : null;

  return (
    <div className="events__info">
      {skeleton}
      {errorMessage}
      {spinner}
      {content}
    </div>
  );
};

const View = ({ event }) => {
  const { title, description } = event;
  return (
    <div className="event-info__container">
      <div className="event-info__date">11.01.2022</div>
      <h4 className="event-info__name">{title}</h4>
      <p className="event-info__descr">{description}</p>
      
      <p className="event-info__address">Адрес: </p>
      <p className="event-info__location">Метро: </p>

    </div>
  );
};
export default EventInfo;
