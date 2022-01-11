const Skeleton = () => {
  return (
    <div className="skeleton">
      <h4 className="events__more-info">
        Выберите мероприятие,чтобы увидеть детальную информацию
      </h4>

      <div className="pulse skeleton__header">
        <div className="pulse skeleton__circle"></div>
        <div className="pulse skeleton__mini"></div>
      </div>
      <div className="pulse skeleton__block"></div>
      <div className="pulse skeleton__block"></div>
      <div className="pulse skeleton__block"></div>
    </div>
  );
};

export default Skeleton;
