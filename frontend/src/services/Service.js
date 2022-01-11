import { useHttp } from "../hooks/http.hook";

const useService = () => {
  const { loading, request, error, clearError } = useHttp();

  //   const _apiBase = "https://jsonplaceholder.typicode.com/";
  const _apiBase = "https://gateway.marvel.com:443/v1/public/";
  const _apiKey = "apikey=ae8ec0e15efe5dafc93642163047b6d1";
  const _baseOffset = 0;

  const getAllEvents = async (offset = _baseOffset) => {
    const res = await request(
      `${_apiBase}characters?limit=6&offset=${offset}&${_apiKey}`
    );
    return res.data.results.map(_transformEvent);
  };
  const getEvent = async (id) => {
    const res = await request(`${_apiBase}characters/${id}?${_apiKey}`);
    return _transformEvent(res.data.results[0]);
  };

  const _transformEvent = (event) => {
    return {
      id: event.id,
      title: event.name,
      short_description: event.description
        ? `${event.description.slice(0, 130)}...`
        : "Описание мероприятия отсутствует",
      description: event.description
        ? `${event.description.slice(0, 210)}...`
        : "Описание мероприятия отсутствует",
      thumbnail: event.thumbnail.path + "." + event.thumbnail.extension,
    };
  };


  return {
    loading,
    error,
    clearError,
    getAllEvents,
    getEvent,
  };
};

export default useService;
