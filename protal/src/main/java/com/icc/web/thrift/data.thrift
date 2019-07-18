namespace java thrift.generated
typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

struct Person {
    1: optional int id,
    2: optional String name,
    3: optional String addr
}

exception DataException {
    1: optional String code,
    2: optional String msg
}

service DataService {
    Person get(1: required int id) throws (1: DataException exp),
    void savePerson(1: required Person person) throws (1: DataException exp)
}

