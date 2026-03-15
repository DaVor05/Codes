import uuid

class MySingleton:
    # Variables de clase (estáticas)
    _instance = None
    _id = None

    def __new__(cls):
        if cls._instance is None:
            # Si no hay instancia, la creamos
            cls._instance = super(MySingleton, cls).__new__(cls)
            # Generamos un ID único solo la primera vez
            cls._id = uuid.uuid4()
        return cls._instance

    def getId(self):
        return self._id
    
instancial = MySingleton()