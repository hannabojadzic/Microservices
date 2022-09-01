import flask
from flask import Flask, render_template, request
from chatterbot import ChatBot
from chatterbot.trainers import ChatterBotCorpusTrainer
import spacy
from spacy.cli.download import download
download(model="en_core_web_sm")

app = flask.Flask(__name__)
app.config["DEBUG"] = True

english_bot = ChatBot("Chatterbot")
trainer = ChatterBotCorpusTrainer(english_bot)
trainer.train("chatterbot.corpus.english")

@app.route('/', methods=['GET'])
def home():
    return "<h1>Distant Reading Archive</h1><p>This site is a prototype API for distant reading of science fiction novels.</p>"
    
@app.route("/chat")
def get_bot_response():
    print(request)
    print(request.args.get('msg'))
    userText = request.args.get('msg')
    return str(english_bot.get_response(userText))

app.run()